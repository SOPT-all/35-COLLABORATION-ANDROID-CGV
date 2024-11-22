package org.sopt.cgv.feature.seats

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.core.designsystem.component.button.CgvButton
import org.sopt.cgv.core.designsystem.theme.Black
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.PrimaryRed400
import org.sopt.cgv.core.designsystem.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeatConfirmationModal(
    modifier: Modifier = Modifier,
    movieTitle: String,
    chipContents: List<String>,
    onBackClick: () -> Unit,
    onSeatSelectionClick: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = {  },
        sheetState = rememberModalBottomSheetState(),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = movieTitle,
                style = Typography.head6_b_17,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            SeatSelectionChipRow(contents = chipContents)

            Spacer(modifier = Modifier.height(24.dp))

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

                Spacer(modifier = Modifier.width(16.dp))

                CgvButton(
                    text = "좌석선택",
                    textStyle = CGVTheme.typography.head6_b_17,
                    horizontalPadding = 48.dp,
                    verticalPadding = 17.dp,
                    roundedCornerShape = 12.dp,
                    onClick = {},
                    enabled = true
                )
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun SeatConfirmationModalPreview() {

    val ChipContents = listOf(
        "2024.11.05 (월)",
        "구리",
        "10:40 ~ 12:39"
    )

    SeatConfirmationModal(
        modifier = Modifier,
        movieTitle = "글래디에이터 2",
        chipContents = ChipContents,
        onBackClick = {  },
        onSeatSelectionClick = {  }
    )
}