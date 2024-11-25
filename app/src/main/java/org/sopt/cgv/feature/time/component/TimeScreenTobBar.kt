package org.sopt.cgv.feature.time.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.White

@Composable
fun TimeScreenTobBar() {

    val selectedIndex = remember { mutableStateOf(0) }
    val reservationMethods = persistentListOf("영화별예매", "극장별예매", "비교예매")
    val widths = listOf(57, 57, 46)

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TabRow(
            selectedTabIndex = selectedIndex.value,
            modifier = Modifier.width(203.dp),
            containerColor = Color.Transparent,
            contentColor = Color.Transparent,
            indicator = { tabPositions ->
                TabRowDefaults.PrimaryIndicator(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedIndex.value]),
                    width = widths[selectedIndex.value].dp,
                    height = 2.dp,
                    color = White
                )
            },
            divider = {}
        ) {
            reservationMethods.forEachIndexed { index, method ->
                Tab(
                    selected = selectedIndex.value == index,
                    onClick = { selectedIndex.value = index },
                    modifier = Modifier
                        .height(30.dp)
                        .padding(vertical = 5.dp),
                    selectedContentColor = White,
                    unselectedContentColor = White
                ) {
                    Text(
                        text = method,
                        style = CGVTheme.typography.body2_m_13
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_x),
            contentDescription = ""
        )
    }
}