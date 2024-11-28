package org.sopt.cgv.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray100
import org.sopt.cgv.core.designsystem.theme.PrimaryRed600
import org.sopt.cgv.core.designsystem.theme.White
import org.sopt.cgv.feature.home.component.CgvFooter
import org.sopt.cgv.feature.home.component.CgvMovieChartSection
import org.sopt.cgv.feature.home.component.CgvMySection
import org.sopt.cgv.feature.home.component.CgvPagerSection
import org.sopt.cgv.feature.home.component.CgvTabBar
import org.sopt.cgv.feature.home.component.CgvTopBar
import org.sopt.cgv.feature.home.data.HomeLocalData
import org.sopt.cgv.feature.home.data.HomeLocalData.navigationItems


@Composable
fun HomeRoute(
    onTicketClick: () -> Unit,
    onSearchClick: () -> Unit,
    onMenuClick: () -> Unit,
    onReservationClick: () -> Unit,
) {

    HomeScreen(
        onTicketClick = onTicketClick,
        onSearchClick = onSearchClick,
        onMenuClick = onMenuClick,
        onReservationClick = onReservationClick
    )
}

@Composable
fun HomeScreen(
    onTicketClick: () -> Unit,
    onSearchClick: () -> Unit,
    onMenuClick: () -> Unit,
    onReservationClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(Gray100)
    ) {
        CgvTopBar(
            onTicketClick = onTicketClick,
            onSearchClick = onSearchClick,
            onMenuClick = onMenuClick
        )

        CgvTabBar(
            contentsList = navigationItems,
            backgroundColor = PrimaryRed600,
            selectedTextColor = White,
            unselectedTextColor = White.copy(alpha = 0.8f),
            indicatorColor = White,
            textStyle = CGVTheme.typography.head3_b_14,
            indicatorHeight = 2.dp,
            startPadding = 16.dp
        )

        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(R.drawable.img_home_ad1),
                contentDescription = null,
            )

            CgvMovieChartSection(
                title = "무비차트",
                view = "전체보기",
                indicators = HomeLocalData.movieChartTypes,
                movies = HomeLocalData.sampleMovies,
                showViewAll = true,
                onReservationClick = onReservationClick
            )

            Spacer(
                modifier = Modifier
                    .height(10.dp)
                    .background(Gray100)
            )

            CgvMySection(
                title = "나의 CGV",
                view = "자세히 보기",
                showViewAll = true,
                onViewAllClick = {},
            )

            Spacer(
                modifier = Modifier
                    .height(10.dp)
                    .background(Gray100)
            )

            CgvPagerSection(
                title = "특별관",
                view = "전체보기",
                images = HomeLocalData.specialCgvImages,
                indicators = HomeLocalData.specialCgvTypes,
                movies = HomeLocalData.specialCgvSmallMovies,
                showViewAll = true,
            )

            Spacer(
                modifier = Modifier
                    .height(10.dp)
                    .background(Gray100)
            )

            CgvPagerSection(
                title = "오늘의 CGV",
                view = "",
                images = HomeLocalData.todayCgvImages,
                indicators = HomeLocalData.todayCgvTypes,
                movies = HomeLocalData.todayCgvSmallMovies,
                showViewAll = false,
            )

            CgvFooter()
        }
    }
}
