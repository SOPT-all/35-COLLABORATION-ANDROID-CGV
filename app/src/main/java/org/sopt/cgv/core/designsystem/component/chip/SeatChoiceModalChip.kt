package org.sopt.cgv.core.designsystem.component.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.cgv.core.designsystem.theme.Gray100
import org.sopt.cgv.core.designsystem.theme.Gray700
import org.sopt.cgv.core.designsystem.theme.Typography

@Composable
fun SeatChoiceModalChip(
    modifier: Modifier = Modifier,
    type: String,   //Date, Location, Time 으로 구분
    content: String
){

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Gray100)
            .padding(vertical = 6.dp, horizontal = 8.dp),
    ){
        Text(
            text = content,
            color = Gray700,
            style = Typography.head3_b_14
        )
    }
}

@Preview
@Composable
fun SeatChoiceModalChipPreview(){
    SeatChoiceModalChip(
        modifier = Modifier,
        type = "Date",
        content = "2024.11.9 (토)"
    )
}