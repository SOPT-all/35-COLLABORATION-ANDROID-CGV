package org.sopt.cgv.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.cgv.core.common.extension.noRippleClickable
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.PrimaryRed400
import org.sopt.cgv.core.designsystem.theme.White

@Composable
fun ReservationButton(
    modifier: Modifier = Modifier,
    text: String,
    horizontalPadding: Dp = 54.dp,
    verticalPadding: Dp = 8.dp,
    textStyle: TextStyle = CGVTheme.typography.head3_b_14,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(4.dp))
            .background(color = PrimaryRed400)
            .noRippleClickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = textStyle,
            color = White,
            modifier = Modifier.padding(horizontal = horizontalPadding, vertical = verticalPadding)
        )
    }
}

@Preview
@Composable
private fun ReservationButtonPreview() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        ReservationButton(
            text = "지금예매",
            horizontalPadding = 54.dp,
            verticalPadding = 8.dp,
            textStyle = CGVTheme.typography.head3_b_14
            )
        ReservationButton(
            text = "예매",
            horizontalPadding = 4.dp,
            verticalPadding = 0.dp,
            textStyle = CGVTheme.typography.body1_m_12
        )
    }
}
