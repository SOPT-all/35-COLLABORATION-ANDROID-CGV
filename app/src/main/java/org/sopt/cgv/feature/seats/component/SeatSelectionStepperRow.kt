package org.sopt.cgv.feature.seats.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.cgv.core.designsystem.theme.Black
import org.sopt.cgv.core.designsystem.theme.CGVTheme

@Composable
fun StepperRow(
    modifier: Modifier = Modifier,
    viewModel: SeatSelectViewModel,
    label: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = CGVTheme.typography.body4_m_15,
            color = Black
        )
        Stepper(
            modifier = Modifier,
            viewModel = viewModel,
            label = label
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StepperRowPreview(){
    StepperRow(
        viewModel = SeatSelectViewModel(),
        label = "어린이",
    )
}
