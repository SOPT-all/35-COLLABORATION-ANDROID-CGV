package org.sopt.cgv.feature.time.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gradient
import org.sopt.cgv.core.designsystem.theme.White

@Composable
fun TimeScreenTobBar(
    selectedTimeScreenTobBarTabIndex: Int,
    onTimeScreenTobBarTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val reservationMethods = persistentListOf("영화별예매", "극장별예매", "비교예매")

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(84.dp)
            .background(Gradient)
    ) {
        Spacer(modifier = Modifier.height(54.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CGVTabRow(
                selectedTabIndex = selectedTimeScreenTobBarTabIndex,
                modifier = Modifier.wrapContentWidth(),
                contentColor = Color.Transparent,
                edgePadding = 0.dp
            ) {
                reservationMethods.forEachIndexed { index, method ->
                    CGVTab(
                        selected = selectedTimeScreenTobBarTabIndex == index,
                        onClick = { onTimeScreenTobBarTabSelected(index) },
                        modifier = Modifier
                            .height(30.dp)
                            .padding(vertical = 5.dp),
                        selectedContentColor = White
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
                contentDescription = "",
                tint = White
            )
        }
    }
}

@Preview
@Composable
private fun TimeScreenTobBarPreview() {
    val selectedTimeScreenTobBarTabIndex = remember { mutableIntStateOf(0) }

    TimeScreenTobBar(
        selectedTimeScreenTobBarTabIndex = selectedTimeScreenTobBarTabIndex.intValue,
        onTimeScreenTobBarTabSelected = { selectedTimeScreenTobBarTabIndex.intValue = it }
    )
}

