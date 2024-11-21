package org.sopt.cgv.feature.seats

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.core.designsystem.component.chip.Chip
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment

@Composable
fun SeatSelectionChipRow(
    modifier: Modifier = Modifier,
    contents: List<String>,
){
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        modifier = modifier.fillMaxWidth()
    ) {
        contents.forEach {
                chipContent ->
            Chip(content = chipContent)
        }
    }

}


@Preview(showBackground = true)
@Composable
fun SeatSelectionChipRowPreview(){
    val ChipContents = listOf(
        "2024.11.05 (월)",
        "구리",
        "10:40 ~ 12:39"
    )
    SeatSelectionChipRow(contents = ChipContents)
}