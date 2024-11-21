package org.sopt.cgv.feature.seats

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.cgv.core.designsystem.theme.Typography

@Composable
fun StepperRow(label: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = Typography.body4_m_15,
            color = Color.Black
        )
        Stepper(
            modifier = Modifier,
            initialValue = 0,
            onValueChange = { newValue ->
                println("$label 인원: $newValue")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StepperRowPreview(){
    StepperRow(
        label = "하이"
    )
}
