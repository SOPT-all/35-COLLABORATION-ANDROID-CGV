package org.sopt.cgv.feature.time

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray850
import org.sopt.cgv.core.designsystem.theme.PrimaryRed400
import org.sopt.cgv.core.designsystem.theme.White

@Composable
fun TheaterClassificationTabInModal(
    selectedIndex: MutableState<Int>,
    tabs: PersistentList<String>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp)
    ) {
        TabRow(
            selectedTabIndex = selectedIndex.value,
            containerColor = White,
            contentColor = White,
            indicator = { tabPositions ->
                TabRowDefaults.PrimaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedIndex.value]),
                    width = 175.dp,
                    height = 2.dp,
                    color = PrimaryRed400
                )
            },
            divider = {}
        ) {
            tabs.forEachIndexed { index, category ->
                Tab(
                    // 지금 여기는 Ripple효과가 제거가 안되네요.. custom으로 만들겠습니다 추후에
                    selected = selectedIndex.value == index,
                    modifier = Modifier
                        .padding(vertical = 10.dp),
                    onClick = { selectedIndex.value = index },
                    selectedContentColor = PrimaryRed400,
                    unselectedContentColor = Gray850,
                ) {
                    Text(
                        text = category,
                        style = CGVTheme.typography.body3_m_14
                    )
                }
            }
        }
    }
}