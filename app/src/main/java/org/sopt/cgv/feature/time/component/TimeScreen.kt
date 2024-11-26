package org.sopt.cgv.feature.time.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeScreen(
    modifier: Modifier = Modifier
) {
    val isSheetOpen = remember { mutableStateOf(true) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val selectedTabInModalIndex = remember { mutableIntStateOf(0) }
    val selectedRegionInModal = remember { mutableStateOf("추천 CGV") }
    val selectedTheaters = remember { mutableStateOf(setOf<String>()) }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = { isSheetOpen.value = !(isSheetOpen.value) }
        ) { }
    }

    TheaterSelectionModalBottomSheet(
        isSheetOpen = isSheetOpen.value,
        onDismissRequest = { isSheetOpen.value = false },
        sheetState = sheetState,
        selectedTabInModalIndex = selectedTabInModalIndex.intValue,
        onCGVTabInModalSelected = { selectedTabInModalIndex.intValue = it },
        selectedRegionInModal = selectedRegionInModal.value,
        onRegionInModalSelected = { selectedRegionInModal.value = it},
        selectedTheaters = selectedTheaters.value,
        onTheaterSelected = {
            if(selectedTheaters.value.contains(it)) selectedTheaters.value -= it
            else selectedTheaters.value += it
        }
    )
}

@Preview
@Composable
fun TimeScreenPreview() {
    TimeScreen()
}