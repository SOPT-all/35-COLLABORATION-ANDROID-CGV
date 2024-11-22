package org.sopt.cgv.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.R

data class MovieItem(
    val movieImageRes: Int,
    val movieTitle: String,
    val likePercentage: String,
    val rating: String,
    val ageRatingIcon: Int
)

@Composable
fun MovieChart(
    movies: PersistentList<MovieItem>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 20.dp)
    ) {
        items(movies) { movie ->
            MovieCard(
                movieImageRes = movie.movieImageRes,
                movieTitle = movie.movieTitle,
                likePercentage = movie.likePercentage,
                rating = movie.rating,
                ageRatingIcon = movie.ageRatingIcon
            )
        }
    }
}

@Preview(
    apiLevel = 33,
)
@Composable
private fun MovieListPreview() {
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
            ageRatingIcon = R.drawable.ic_15
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
            movieImageRes = R.drawable.img_movie3,
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
            ageRatingIcon = R.drawable.ic_15
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
            ageRatingIcon = R.drawable.ic_15
        )
    )
    MovieChart(movies = sampleMovies)
}
