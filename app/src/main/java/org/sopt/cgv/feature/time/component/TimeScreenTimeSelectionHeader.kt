package org.sopt.cgv.feature.time.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.component.button.CgvButton
import org.sopt.cgv.core.designsystem.theme.Black
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray100
import org.sopt.cgv.core.designsystem.theme.Gray400
import org.sopt.cgv.core.designsystem.theme.Gray600
import org.sopt.cgv.core.designsystem.theme.PrimaryRed400
import org.sopt.cgv.core.designsystem.theme.White

@Composable
fun TimeScreenTimeSelectionHeader(
    onSheetStateChanged: () -> Unit,
    numberOfSelectedTheaters: Int,
    initTimeTableList: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Gray100)
            .padding(horizontal = 18.dp, vertical = 12.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "선택된 극장 ",
                style = CGVTheme.typography.body1_m_12,
                color = Black
            )

            Text(
                text = numberOfSelectedTheaters.toString(),
                style = CGVTheme.typography.head1_b_12,
                color = PrimaryRed400
            )

            Spacer(modifier = Modifier.width(10.dp))

            CgvButton(
                text = "극장변경",
                textStyle = CGVTheme.typography.body1_m_12,
                textColor = Gray600,
                background = White,
                borderColor = Gray400,
                horizontalPadding = 10.dp,
                verticalPadding = 6.dp,
                roundedCornerShape = 6.dp,
                onClick = {
                    onSheetStateChanged()
                    initTimeTableList()
                }
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_filter),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier.padding(5.dp)
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = "필터",
                style = CGVTheme.typography.body3_m_14,
                color = Black
            )
        }
    }
}

@Composable
@Preview
private fun TimeScreenTimeSelectionHeaderPreview() {
    val isSheetOpen = remember { mutableStateOf(true) }

    TimeScreenTimeSelectionHeader(
        onSheetStateChanged = { isSheetOpen.value = !isSheetOpen.value },
        initTimeTableList = {},
        numberOfSelectedTheaters = 2
    )
}