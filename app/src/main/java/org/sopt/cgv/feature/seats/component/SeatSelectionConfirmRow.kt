package org.sopt.cgv.feature.seats.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.core.designsystem.theme.Black
import org.sopt.cgv.core.designsystem.theme.CGVTheme

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
            modifier = Modifier
                .height(30.dp)
                .padding(vertical = 3.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = label,
                style = CGVTheme.typography.body4_m_15,
                color = Black
            )

            Spacer(modifier = Modifier.width(10.dp))

            SeatSelectionChangeButton(content = "인원변경",
                horizontalPadding = 6.dp, verticalPadding = 2.dp)
        }

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = price,
                style = CGVTheme.typography.head8_b_20,
                color = Black
            )
            Text(
                text = "원",
                style = CGVTheme.typography.head4_b_15,
                color = Black
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