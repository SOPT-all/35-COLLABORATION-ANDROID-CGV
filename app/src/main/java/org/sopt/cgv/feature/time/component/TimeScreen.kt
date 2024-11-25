package org.sopt.cgv.feature.time.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.core.designsystem.theme.Gradient
import org.sopt.cgv.core.designsystem.theme.White

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

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .background(Gradient)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 220.dp)
                .background(White)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(top = 19.dp)
        ) {
            TimeScreenTobBar()

            Spacer(modifier = Modifier.height(19.dp))

            TimeScreenMovieSelectionSection()

            Spacer(modifier = Modifier.height(19.dp))

            TimeScreenDateSelectionTab()

            Spacer(modifier = Modifier.height(22.dp))

            TimeScreenTimeSelectionHeader(
                isSheetOpen = isSheetOpen
            )
        }
    }


    TheaterSelectionModalBottomSheet(
        isSheetOpen = isSheetOpen,
        onDismissRequest = { isSheetOpen.value = false },
        sheetState = sheetState,
        selectedTabInModalIndex = selectedTabInModalIndex,
        selectedRegionInModal = selectedRegionInModal,
        selectedTheaters = selectedTheaters
    )
}

@Preview
@Composable
fun TimeScreenPreview() {
    TimeScreen()
}