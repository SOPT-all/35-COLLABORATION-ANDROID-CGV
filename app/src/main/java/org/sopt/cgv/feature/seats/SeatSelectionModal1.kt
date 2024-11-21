package org.sopt.cgv.feature.seats

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.core.designsystem.component.button.ModalButton
import org.sopt.cgv.core.designsystem.theme.Black
import org.sopt.cgv.core.designsystem.theme.Typography
import org.sopt.cgv.core.designsystem.component.chip.Chip

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeatSelectionModal1(
    seatSelectionMovieTitle: String,
    chipContents: List<String>,
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
                text = seatSelectionMovieTitle,
                style = Typography.head6_b_17,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            SeatSelectionChipRow(contents = chipContents)

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
                horizontalArrangement = Arrangement.Center
            ) {
                ModalButton(
                    modifier = Modifier,
                    buttonType = "Back",
                    initialActivation = false,
                    content = "뒤로가기",
                    length = "half"
                )

                Spacer(modifier = Modifier.width(16.dp))

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


@Preview(showBackground = true)
@Composable
fun SeatSelectionModal1Preview() {
    
    val ChipContents = listOf(
        "2024.11.05 (월)",
        "구리",
        "10:40 ~ 12:39"
    )

    SeatSelectionModal1(
        seatSelectionMovieTitle = "글래디에이터 2",
        chipContents = ChipContents,
        onBackClick = {  },
        onSeatSelectionClick = {  }
    )
}
