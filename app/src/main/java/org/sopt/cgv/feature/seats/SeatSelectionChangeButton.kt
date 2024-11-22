package org.sopt.cgv.feature.seats

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.core.designsystem.theme.Gray400
import org.sopt.cgv.core.designsystem.theme.Gray600
import org.sopt.cgv.core.designsystem.theme.Typography
import org.sopt.cgv.core.designsystem.theme.White

@Composable
fun SeatSelectionChangeButton(
    modifier: Modifier = Modifier,
    content: String
){

    Box(
        modifier = modifier
            .size(width = 66.dp, height = 24.dp)
            .border(BorderStroke(1.dp, Gray400), RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background(White)
            .padding(vertical = 2.dp, horizontal = 6.dp),
    ){
        Text(
            modifier = modifier
                .align(Alignment.Center),
            text = content,
            color = Gray600,
            style = Typography.body1_m_12
        )
    }
}

@Preview
@Composable
fun SeatSelectionChangeButtonPreview(){
    SeatSelectionChangeButton(
        modifier = Modifier,
        content = "인원변경"
    )
}