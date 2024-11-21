package org.sopt.cgv.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.White

@Composable
fun CgvMySection(
    title: String,
    view: String,
    modifier: Modifier = Modifier,
    showViewAll: Boolean = true,
    onViewAllClick: () -> Unit = {},
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

        Column(
            modifier = Modifier.padding(horizontal = 18.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            MyCgvComponent(
                leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_home_movie),
                title = "내가 본 영화",
                count = 9
            )

            MyCgvComponent(
                leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_home_like),
                title = "기대되는 영화",
                count = 2
            )

            MyCgvComponent(
                leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_home_pen),
                title = "내가 쓴 리뷰",
                count = 1
            )

            Spacer(modifier = Modifier.padding(16.dp))
        }
    }
}

@Preview
@Composable
fun CgvMySectionPreview() {
    CGVTheme {
        CgvMySection(
            title = "나의 CGV",
            view = "자세히 보기",
            showViewAll = true,
            onViewAllClick = {},
        )
    }
}
