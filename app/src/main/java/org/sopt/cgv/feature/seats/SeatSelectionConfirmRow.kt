package org.sopt.cgv.feature.seats

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.core.designsystem.theme.Typography

@Composable
fun SeatSelectionConfirmRow(
    label: String,
    price: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = label,
                style = Typography.body4_m_15,
                color = Color.Black
            )

            Spacer(modifier = Modifier.width(10.dp))

            SeatSelectionChangeButton(content = "인원변경")
        }

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = price,
                style = Typography.head8_b_20,
                color = Color.Black
            )
            Text(
                text = "원",
                style = Typography.head4_b_15,
                color = Color.Black
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun SeatSelectionConfirmRowPreview(){
    SeatSelectionConfirmRow(
        label = "일반1",
        price = "14,000"
    )
}