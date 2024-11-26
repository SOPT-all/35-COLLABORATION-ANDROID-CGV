package org.sopt.cgv.feature.time.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.sopt.cgv.core.common.extension.dropShadow
import org.sopt.cgv.core.designsystem.component.button.CgvButton
import org.sopt.cgv.core.designsystem.component.chip.Chip
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TheaterSelectionModalFooter(
    sheetState: SheetState,
    onDismissRequest: () -> Unit,
    selectedTheaters: MutableState<Set<String>>,
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .dropShadow(
                shape = RectangleShape,
                color = Color(0x1A000000),
                blur = 10.dp,
                offsetY = (-4).dp,
                offsetX = 0.dp,
                spread = 0.dp
            )
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = White)
                .padding(horizontal = 18.dp)
        ) {
            ShowSelectedChipsBox(
                selectedTheaters = selectedTheaters
            )

            CgvButton(
                modifier = Modifier.fillMaxWidth(),
                text = "극장선택",
                textStyle = CGVTheme.typography.head6_b_17,
                verticalPadding = 16.dp,
                roundedCornerShape = 10.dp,
                onClick = {
                    coroutineScope.launch {
                        sheetState.hide()
                        onDismissRequest()
                    }
                }
            )

            Spacer(modifier = Modifier.height(38.dp))
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ShowSelectedChipsBox(
    modifier: Modifier = Modifier,
    selectedTheaters: MutableState<Set<String>>
) {
    FlowRow(
        modifier = Modifier.padding(vertical = 14.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        selectedTheaters.value.forEach { theaterName ->
            Chip(
                content = theaterName,
                inTime = true,
                selectedTheaters = selectedTheaters
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun TheaterSelectionModalFooterPreview() {
    val selectedTheaters = remember { mutableStateOf(setOf<String>("구리", "압구정")) }
    TheaterSelectionModalFooter(
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
        onDismissRequest = {},
        selectedTheaters = selectedTheaters,
        modifier = Modifier
    )
}

@Preview
@Composable
private fun ShowSelectedChipsBoxPreview() {
    val selectedTheaters = remember { mutableStateOf(setOf<String>("구리", "압구정")) }
    ShowSelectedChipsBox(
        modifier = Modifier,
        selectedTheaters = selectedTheaters
    )
}
