package org.sopt.cgv.feature.home.component

import androidx.compose.foundation.background
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
import org.sopt.cgv.feature.home.data.MovieItem

@Composable
fun CgvMovieChartSection(
    title: String,
    view: String,
    indicators: PersistentList<String>,
    movies: PersistentList<MovieItem>,
    modifier: Modifier = Modifier,
    showViewAll: Boolean = true,
    onClick: () -> Unit = {},
    onIndicatorSelected: (Int) -> Unit = {},
    onReservationClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .background(White)
    ) {
        SectionHeader(
            title = title,
            view = view,
            showViewAll = showViewAll,
            onViewAllClick = onClick
        )

        Spacer(modifier = Modifier.height(8.dp))

        CgvTabBar(
            contentsList = indicators,
            onIndexSelected = onIndicatorSelected,
            modifier = Modifier.padding(start = 18.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

        MovieChart(
            movies = movies,
            onReservationClick = onReservationClick
        )

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun CgvMovieChartSectionPreview() {
    CGVTheme {
        val movieChartTypes = persistentListOf(
            "예매차트",
            "현재상영작",
            "ICECON",
            "아트하우스",
            "CGV Only"
        )

        val sampleMovies = persistentListOf(
            MovieItem(
                movieImageRes = R.drawable.img_movie1,
                movieTitle = "청설",
                likePercentage = "99.9",
                rating = "D-1",
                ageRatingIcon = R.drawable.ic_all
            ),
            MovieItem(
                movieImageRes = R.drawable.img_movie2,
                movieTitle = "글래디애이터 II",
                likePercentage = "99.9",
                rating = "D-1",
                ageRatingIcon = R.drawable.ic_19
            ),
            MovieItem(
                movieImageRes = R.drawable.img_movie3,
                movieTitle = "대도시의 사랑법",
                likePercentage = "99.9",
                rating = "D-1",
                ageRatingIcon = R.drawable.ic_15
            ),
            MovieItem(
                movieImageRes = R.drawable.img_movie4,
                movieTitle = "위키드",
                likePercentage = "99.9",
                rating = "D-1",
                ageRatingIcon = R.drawable.ic_all
            ),
            MovieItem(
                movieImageRes = R.drawable.img_movie5,
                movieTitle = "베놈: 라스트 댄스",
                likePercentage = "99.9",
                rating = "D-1",
                ageRatingIcon = R.drawable.ic_15
            ),
            MovieItem(
                movieImageRes = R.drawable.img_movie6,
                movieTitle = "히든페이스",
                likePercentage = "99.9",
                rating = "D-1",
                ageRatingIcon = R.drawable.ic_19
            ),
            MovieItem(
                movieImageRes = R.drawable.img_movie7,
                movieTitle = "괴물",
                likePercentage = "99.9",
                rating = "D-1",
                ageRatingIcon = R.drawable.ic_12
            ),
            MovieItem(
                movieImageRes = R.drawable.img_movie8,
                movieTitle = "아메바 소녀들과 학교괴담",
                likePercentage = "99.9",
                rating = "D-1",
                ageRatingIcon = R.drawable.ic_15
            ),
            MovieItem(
                movieImageRes = R.drawable.img_movie9,
                movieTitle = "캐롤",
                likePercentage = "99.9",
                rating = "D-1",
                ageRatingIcon = R.drawable.ic_19
            )

        )

        CgvMovieChartSection(
            title = "무비차트",
            view = "전체보기",
            indicators = movieChartTypes,
            movies = sampleMovies,
            showViewAll = true,
            onClick = {},
            onIndicatorSelected = {}
        )
    }
}
