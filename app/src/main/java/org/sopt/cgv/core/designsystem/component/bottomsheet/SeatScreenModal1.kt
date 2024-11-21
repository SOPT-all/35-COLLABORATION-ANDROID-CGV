package org.sopt.cgv.core.designsystem.component.bottomsheet

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.sopt.cgv.core.designsystem.component.button.ModalButton
import org.sopt.cgv.core.designsystem.component.button.Stepper
import org.sopt.cgv.core.designsystem.component.chip.SeatChoiceModalChip
import org.sopt.cgv.core.designsystem.theme.Black
import org.sopt.cgv.core.designsystem.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeatScreenModal1(
    onBackClick: () -> Unit,
    onSeatSelectionClick: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = {  },
        sheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = true
        ),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "글래디에이터 2",
                style = Typography.head6_b_17,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                SeatChoiceModalChip(type = "Date", content = "2024.11.05 (월)")
                SeatChoiceModalChip(type = "Location", content = "구리")
                SeatChoiceModalChip(type = "Time", content = "10:40 ~ 12:39")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "인원선택",
                style = Typography.head3_b_14,
                color = Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                StepperRow("일반")
                StepperRow("청소년")
                StepperRow("경로")
                StepperRow("우대")
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                ModalButton(
                    modifier = Modifier,
                    buttonType = "Back",
                    initialActivation = false,
                    content = "뒤로가기",
                    length = "half"
                )
                ModalButton(
                    modifier = Modifier,
                    buttonType = "Choice",
                    initialActivation = false,
                    content = "좌석선택",
                    length = "half"
                )
            }
        }
    }
}


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
fun ReservationBottomSheetPreview() {
    SeatScreenModal1(
        onBackClick = {  },
        onSeatSelectionClick = {  }
    )
}
