package org.sopt.cgv.feature.home.data

import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.R

object HomeLocalData {
    val navigationItems = persistentListOf("홈", "이벤트", "패스트오더", "기프트샵", "@CGV")

    val movieChartTypes = persistentListOf("예매차트", "현재상영작", "ICECON", "아트하우스", "CGV Only")

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

    val specialCgvTypes = persistentListOf(
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

    val specialCgvImages = persistentListOf(
        R.drawable.img_home_imax1,
        R.drawable.img_home_imax2,
        R.drawable.img_home_imax3,
        R.drawable.img_home_imax4
    )

    val specialCgvSmallMovies = persistentListOf(
        SpecialTheaterMovieItem(
            id = 1,
            imageUrl = R.drawable.img_special1,
            title = "글래디에이터 II",
            percentage = "17.3%"
        ),
        SpecialTheaterMovieItem(
            id = 2,
            imageUrl = R.drawable.img_special2,
            title = "위키드",
            percentage = "16.5%"
        ),
        SpecialTheaterMovieItem(
            id = 3,
            imageUrl = R.drawable.img_special3,
            title = "베놈: 라스트 댄스",
            percentage = "1.3%"
        )
    )

    val todayCgvTypes = persistentListOf(
        "HOT 예고편",
        "HOT 이벤트",
        "상영종료예정",
        "인기 CGV",
        "오늘의 굿즈"
    )

    val todayCgvImages = persistentListOf(
        R.drawable.img_home_hot1,
        R.drawable.img_home_hot2,
        R.drawable.img_home_hot3,
        R.drawable.img_home_hot4
    )

    val todayCgvSmallMovies = persistentListOf(
        SpecialTheaterMovieItem(
            id = 1,
            imageUrl = R.drawable.img_today1,
            title = "아마존 활명수",
            percentage = "1.2%"
        ),
        SpecialTheaterMovieItem(
            id = 2,
            imageUrl = R.drawable.img_today2,
            title = "위키드",
            percentage = "17.5%"
        ),
        SpecialTheaterMovieItem(
            id = 3,
            imageUrl = R.drawable.img_today3,
            title = "아메바 소녀들과 학교 괴담",
            percentage = "1.1%"
        )
    )

    val myCgvItems = persistentListOf(
        MyCgvItem(
            iconResId = R.drawable.ic_home_movie,
            title = "내가 본 영화",
            count = 9
        ),
        MyCgvItem(
            iconResId = R.drawable.ic_home_like,
            title = "기대되는 영화",
            count = 2
        ),
        MyCgvItem(
            iconResId = R.drawable.ic_home_pen,
            title = "내가 쓴 리뷰",
            count = 1
        )
    )

}
