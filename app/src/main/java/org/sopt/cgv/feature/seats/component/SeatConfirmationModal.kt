package org.sopt.cgv.feature.seats.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.core.designsystem.component.button.CgvButton
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeatConfirmationModal(
    modifier: Modifier = Modifier,
    movieTitle: String,
    chipContents: PersistentList<String>,
    onDismiss: () -> Unit,
    onBackClick: () -> Unit,
    onSeatSelectionClick: () -> Unit,
    bottomSheetState: SheetState
) {
    if(bottomSheetState.isVisible){

        ModalBottomSheet(
            onDismissRequest = { onDismiss() },
            sheetState = bottomSheetState,
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            containerColor = White
        ) {
            Column(
                modifier = modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = movieTitle,
                    style = CGVTheme.typography.head6_b_17,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                SeatSelectionChipRow(contents = chipContents)

                Spacer(modifier = Modifier.height(24.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    SeatSelectionConfirmRow(label = "일반1", price = "14,000")
                }

                Spacer(modifier = Modifier.height(32.dp))

                CgvButton(
                    text = "좌석선택",
                    textStyle = CGVTheme.typography.head6_b_17,
                    horizontalPadding = 136.dp,
                    verticalPadding = 16.dp,
                    roundedCornerShape = 10.dp,
                    onClick = {}
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = false)
@Composable
fun SeatConfirmationModalPreview() {

    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    val ChipContents = persistentListOf(
        "2024.11.05 (월)",
        "구리",
        "10:40 ~ 12:39"
    )

    SeatConfirmationModal(
        modifier = Modifier,
        movieTitle = "글래디에이터 2",
        chipContents = ChipContents,
        onDismiss = { },
        bottomSheetState = bottomSheetState,
        onBackClick = {  },
        onSeatSelectionClick = {  }
    )
}