package org.sopt.cgv.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.core.common.extension.noRippleClickable
import org.sopt.cgv.core.designsystem.theme.Black
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray600
import org.sopt.cgv.core.designsystem.theme.Gray900
import org.sopt.cgv.core.designsystem.theme.PrimaryRed600
import org.sopt.cgv.core.designsystem.theme.White

@Composable
fun CgvTabBar(
    contentsList: PersistentList<String>,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Transparent,
    selectedTextColor: Color = Gray900,
    unselectedTextColor: Color = Gray600,
    indicatorColor: Color = Black,
    textStyle: TextStyle = CGVTheme.typography.body1_m_12,
    indicatorHeight: Dp = 1.dp,
    startPadding: Dp = 0.dp,
    onIndexSelected: (Int) -> Unit = {}
) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (startPadding > 0.dp) {
            Spacer(modifier = Modifier.width(startPadding))
        }

        contentsList.forEachIndexed { index, content ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .wrapContentWidth()
                    .width(IntrinsicSize.Max)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .noRippleClickable {
                        selectedIndex = index
                        onIndexSelected(index)
                    }
            ) {
                Text(
                    text = content,
                    style = textStyle,
                    color = if (selectedIndex == index) {
                        selectedTextColor
                    } else {
                        unselectedTextColor
                    },
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.padding(3.dp))
                Box(
                    modifier = Modifier
                        .height(indicatorHeight)
                        .fillMaxWidth()
                        .background(
                            color = if (selectedIndex == index) {
                                indicatorColor
                            } else {
                                Color.Transparent
                            }
                        )
                )
            }
        }
    }
}

@Preview
@Composable
private fun CGVIndicatorPreview1() {
    val theaterTypes = persistentListOf(
        "예매차트",
        "현재상영작",
        "ICECON",
        "아트하우스",
        "CGV Only"
    )

    Column {
        CgvTabBar(contentsList = theaterTypes)
    }
}

@Preview
@Composable
private fun CGVIndicatorPreview2() {
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

    Column {
        CgvTabBar(contentsList = theaterTypes)
    }
}

@Preview
@Composable
private fun CGVIndicatorPreview3() {
    val theaterTypes = persistentListOf(
        "HOT 예고편",
        "HOT 이벤트",
        "상영종료예정",
        "인기 CGV",
        "오늘의 굿즈"
    )

    Column {
        CgvTabBar(contentsList = theaterTypes)
    }
}

@Preview
@Composable
private fun CGVNavigationPreview4() {
    val navigationItems = persistentListOf(
        "홈",
        "이벤트",
        "패스트오더",
        "기프트샵",
        "@CGV"
    )

    Column {
        Spacer(modifier = Modifier.padding(start = 18.dp))
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
    }
}
