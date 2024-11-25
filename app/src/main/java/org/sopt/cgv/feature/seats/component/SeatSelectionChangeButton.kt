package org.sopt.cgv.feature.seats.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray400
import org.sopt.cgv.core.designsystem.theme.Gray600
import org.sopt.cgv.core.designsystem.theme.White

@Composable
fun SeatSelectionChangeButton(
    modifier: Modifier = Modifier,
    horizontalPadding: Dp = 6.dp,
    verticalPadding: Dp = 2.dp,
    content: String
){
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .fillMaxHeight()
            .border(BorderStroke(1.dp, Gray400), RoundedCornerShape(6.dp))
            .background(White)
    ){
        Text(
            modifier = modifier
                .align(Alignment.Center)
                .padding(horizontal = horizontalPadding, vertical = verticalPadding),
            text = content,
            color = Gray600,
            style = CGVTheme.typography.body1_m_12
        )
    }
}

@Preview
@Composable
fun SeatSelectionChangeButtonPreview(){
    Column(
        modifier = Modifier.height(24.dp)
    ){
        SeatSelectionChangeButton(
            modifier = Modifier,
            content = "인원변경",
            horizontalPadding = 6.dp,
            verticalPadding = 2.dp
        )
    }

}