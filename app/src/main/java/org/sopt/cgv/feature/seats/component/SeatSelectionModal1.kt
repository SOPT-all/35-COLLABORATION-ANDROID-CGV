package org.sopt.cgv.feature.seats.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.core.designsystem.component.button.CgvButton
import org.sopt.cgv.core.designsystem.theme.Black
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.PrimaryRed400
import org.sopt.cgv.core.designsystem.theme.White
import androidx.compose.material3.ExperimentalMaterial3Api


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeatSelectionModal1(
    modifier: Modifier = Modifier,
    viewModel: SeatSelectViewModel,
    movieTitle: String,
    chipContents: PersistentList<String>,
    onDismiss: () -> Unit,
    onBackClick: () -> Unit,
    onSeatSelectionClick: () -> Unit,
    bottomSheetState: SheetState
) {
    if (bottomSheetState.isVisible){
        ModalBottomSheet(
            onDismissRequest = { onDismiss() },
            sheetState = bottomSheetState,
            dragHandle = { },
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            containerColor = White
        ) {
            Column(
                modifier = modifier
                    .padding(vertical = 30.dp, horizontal = 20.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = movieTitle,
                    style = CGVTheme.typography.head6_b_17,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                SeatSelectionChipRow(contents = chipContents)

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "인원선택",
                    style = CGVTheme.typography.head3_b_14,
                    color = Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    StepperRow( modifier = Modifier, viewModel = viewModel, label = "일반")
                    StepperRow( modifier = Modifier, viewModel = viewModel, label ="청소년")
                    StepperRow( modifier = Modifier, viewModel = viewModel, label ="경로")
                    StepperRow( modifier = Modifier, viewModel = viewModel, label ="우대")
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

                    Spacer(modifier = Modifier.width(12.dp))

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
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = false)
@Composable
fun SeatSelectionModal1Preview() {

    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    
    val ChipContents = persistentListOf(
        "2024.11.05 (월)",
        "구리",
        "10:40 ~ 12:39"
    )

    SeatSelectionModal1(
        modifier = Modifier,
        movieTitle = "글래디에이터 2",
        chipContents = ChipContents,
        onDismiss = { },
        viewModel = SeatSelectViewModel(),
        bottomSheetState = bottomSheetState,
        onBackClick = {  },
        onSeatSelectionClick = {  }
    )
}
