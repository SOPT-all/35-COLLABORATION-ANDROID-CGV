package org.sopt.cgv.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.R
import org.sopt.cgv.core.common.extension.noRippleClickable
import org.sopt.cgv.core.designsystem.theme.CGVTheme

@Composable
fun SectionHeader(
    title: String,
    view: String,
    modifier: Modifier = Modifier,
    showViewAll: Boolean = true,
    onViewAllClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 19.dp, end = 9.dp)
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = CGVTheme.typography.head7_b_18,
            modifier = Modifier.weight(1f)
        )
        if (showViewAll) {
            Row(
                modifier = Modifier.noRippleClickable { onViewAllClick() },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = view,
                    style = CGVTheme.typography.body1_m_12
                )
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_arrow_right),
                    contentDescription = null
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SectionHeaderPreview() {
    CGVTheme {
        SectionHeader(
            title = "무비차트",
            view = "전체보기",
            showViewAll = true,
            onViewAllClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SectionHeaderPreview2() {
    CGVTheme {
        SectionHeader(
            title = "특별관",
            view = "전체보기",
            showViewAll = true,
            onViewAllClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SectionHeaderPreview3() {
    CGVTheme {
        SectionHeader(
            title = "나의 CGV",
            view = "자세히 보기",
            showViewAll = true,
            onViewAllClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SectionHeaderPreview4() {
    CGVTheme {
        SectionHeader(
            title = "오늘의 CGV",
            view = "",
            showViewAll = false,
            onViewAllClick = {}
        )
    }
}
