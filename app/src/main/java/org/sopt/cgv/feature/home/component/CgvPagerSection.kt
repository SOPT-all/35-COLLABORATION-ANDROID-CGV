package org.sopt.cgv.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.White
import org.sopt.cgv.feature.home.data.SpecialTheaterMovieItem

@Composable
fun CgvPagerSection(
    title: String,
    view: String,
    images: PersistentList<Int>,
    indicators: PersistentList<String>,
    movies: PersistentList<SpecialTheaterMovieItem>,
    modifier: Modifier = Modifier,
    showViewAll: Boolean = true,
    onViewAllClick: () -> Unit = {},
    onIndicatorSelected: (Int) -> Unit = {}
) {
    Column(
        modifier = modifier
            .background(White)
    ) {
        SectionHeader(
            title = title,
            view = view,
            showViewAll = showViewAll,
            onViewAllClick = onViewAllClick
        )

        Spacer(modifier = Modifier.height(8.dp))
        CgvTabBar(
            contentsList = indicators,
            onIndexSelected = onIndicatorSelected,
            modifier = Modifier.padding(start = 18.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))
        ImageIndicator(
            modifier = Modifier.padding(horizontal = 18.dp),
            images = images
        )

        Spacer(modifier = Modifier.height(24.dp))
        Column(
            modifier = Modifier.padding(horizontal = 18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            movies.forEach { movie ->
                MovieSmallCard(
                    movieImage = movie.imageUrl,
                    title = movie.title,
                    percentage = movie.percentage
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun CgvPagerSectionPreview() {
    CGVTheme {
        val sampleImaxImages = persistentListOf(
            R.drawable.img_home_imax1,
            R.drawable.img_home_imax2,
            R.drawable.img_home_imax3,
            R.drawable.img_home_imax4
        )

        val theaterTypes = persistentListOf(
            "IMAX",
            "SCREENX",
            "4DX",
            "ULTRA 4DX",
            "Gold Class",
            "Tempur",
            "씨네&포레",
            "씨네앤포레",
            "프라이빗박스"
        )

        val movieDetails = persistentListOf(
            SpecialTheaterMovieItem(
                id = 1,
                imageUrl = R.drawable.img_special1,
                title = "윙카",
                percentage = "22.1%"
            ),
            SpecialTheaterMovieItem(
                id = 2,
                imageUrl = R.drawable.img_special2,
                title = "듄: 파트2",
                percentage = "19.4%"
            ),
            SpecialTheaterMovieItem(
                id = 3,
                imageUrl = R.drawable.img_special1,
                title = "가여운 것들",
                percentage = "16.2%"
            )
        )


        CgvPagerSection(
            title = "특별관",
            view = "전체보기",
            images = sampleImaxImages,
            indicators = theaterTypes,
            movies = movieDetails,
            showViewAll = true,
            onViewAllClick = {},
            onIndicatorSelected = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CgvPagerSectionPreview2() {
    CGVTheme {
        val sampleHotImages = persistentListOf(
            R.drawable.img_home_hot1,
            R.drawable.img_home_hot2,
            R.drawable.img_home_hot3,
            R.drawable.img_home_hot4
        )

        val hotTypes = persistentListOf(
            "HOT 예고편",
            "HOT 이벤트",
            "상영종료예정",
            "인기 CGV",
            "오늘의 굿즈"
        )

        val movieDetails = persistentListOf(
            SpecialTheaterMovieItem(
                id = 1,
                imageUrl = R.drawable.img_special1,
                title = "윙카",
                percentage = "22.1%"
            ),
            SpecialTheaterMovieItem(
                id = 2,
                imageUrl = R.drawable.img_special2,
                title = "듄: 파트2",
                percentage = "19.4%"
            ),
            SpecialTheaterMovieItem(
                id = 3,
                imageUrl = R.drawable.img_special1,
                title = "가여운 것들",
                percentage = "16.2%"
            )
        )

        CgvPagerSection(
            title = "오늘의 CGV",
            view = "",
            images = sampleHotImages,
            indicators = hotTypes,
            showViewAll = false,
            movies = movieDetails,
            onIndicatorSelected = {}
        )
    }
}
