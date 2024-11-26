package org.sopt.cgv.core.designsystem.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.cgv.core.common.extension.noRippleClickable
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray500
import org.sopt.cgv.core.designsystem.theme.PrimaryRed400
import org.sopt.cgv.core.designsystem.theme.White

@Composable
fun CgvButton(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = CGVTheme.typography.head3_b_14,
    textColor: Color = White,
    background: Color = PrimaryRed400,
    borderColor: Color = Color.Transparent,
    horizontalPadding: Dp = 54.dp,
    verticalPadding: Dp = 8.dp,
    roundedCornerShape: Dp = 8.dp,
    onClick: () -> Unit,
    enabled: Boolean = false,
    isBack: Boolean = false,
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(roundedCornerShape))
            .border(BorderStroke(1.dp, borderColor), RoundedCornerShape(roundedCornerShape))
            .background(if (enabled) Gray500 else if (isBack) White else background)
            .noRippleClickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = textStyle,
            color = textColor,
            modifier = Modifier.padding(horizontal = horizontalPadding, vertical = verticalPadding)
        )
    }
}

@Preview
@Composable
private fun CgvButtonPreview() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        CgvButton(
            text = "지금예매",
            textStyle = CGVTheme.typography.head3_b_14,
            horizontalPadding = 56.dp,
            verticalPadding = 8.dp,
            onClick = {}
        )
        CgvButton(
            text = "예매",
            textStyle = CGVTheme.typography.body1_m_12,
            horizontalPadding = 4.dp,
            verticalPadding = 3.dp,
            roundedCornerShape = 4.dp,
            onClick = {}
        )
        CgvButton(
            text = "극장선택",
            textStyle = CGVTheme.typography.head6_b_17,
            horizontalPadding = 136.dp,
            verticalPadding = 16.dp,
            roundedCornerShape = 10.dp,
            onClick = {}
        )
        CgvButton(
            text = "좌석선택",
            textStyle = CGVTheme.typography.head6_b_17,
            horizontalPadding = 136.dp,
            verticalPadding = 16.dp,
            roundedCornerShape = 10.dp,
            onClick = {}
        )
        CgvButton(
            text = "좌석선택",
            textStyle = CGVTheme.typography.head6_b_17,
            horizontalPadding = 48.dp,
            verticalPadding = 17.dp,
            roundedCornerShape = 12.dp,
            onClick = {},
            enabled = true
        )
        CgvButton(
            text = "뒤로가기",
            textStyle = CGVTheme.typography.head6_b_17,
            textColor = PrimaryRed400,
            borderColor = PrimaryRed400,
            horizontalPadding = 48.dp,
            verticalPadding = 17.dp,
            roundedCornerShape = 12.dp,
            onClick = {},
            isBack = true
        )
    }
}

