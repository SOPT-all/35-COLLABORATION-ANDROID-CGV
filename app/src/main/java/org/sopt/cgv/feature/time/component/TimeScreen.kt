package org.sopt.cgv.feature.time.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.theme.Gradient
import org.sopt.cgv.core.designsystem.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeScreen(
    modifier: Modifier = Modifier
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val selectedTabInModalIndex = remember { mutableIntStateOf(0) }
    val selectedRegionInModal = remember { mutableStateOf("추천 CGV") }
    val selectedTheaters = remember { mutableStateOf(setOf<String>()) }
    val selectedTimeScreenTobBarTabIndex = remember { mutableIntStateOf(0) }
    val selectedPoster = remember { mutableIntStateOf(R.drawable.img_time_poster1_selected) }
    val selectedDate = remember { mutableStateOf("11.28") }
    val selectedDay = remember { mutableStateOf("목") }
    val isSheetOpen = remember { mutableStateOf(true) }

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
            TimeScreenTobBar(
                selectedTimeScreenTobBarTabIndex = selectedTimeScreenTobBarTabIndex.intValue,
                onTimeScreenTobBarTabSelected = { selectedTimeScreenTobBarTabIndex.intValue = it }
            )

            Spacer(modifier = Modifier.height(19.dp))

            TimeScreenMovieSelectionSection(
                selectedPoster = selectedPoster.intValue,
                onPosterSelected = { selectedPoster.intValue = it }
            )

            Spacer(modifier = Modifier.height(19.dp))

            TimeScreenDateSelectionTab(
                selectedDate = selectedDate.value,
                onDateSelected = { selectedDate.value = it },
                selectedDay = selectedDay.value,
                onDaySelected = { selectedDay.value = it }
            )

            Spacer(modifier = Modifier.height(22.dp))

            TimeScreenTimeSelectionHeader(
                onSheetStateChanged = {isSheetOpen.value = !isSheetOpen.value},
                numberOfSelectedTheaters = selectedTheaters.value.size
            )

            TimeScreenAuditorioumAndTimeSelection(
                selectedTheaters = selectedTheaters.value
            )
        }
    }

    TheaterSelectionModalBottomSheet(
        isSheetOpen = isSheetOpen.value,
        onDismissRequest = { isSheetOpen.value = false },
        sheetState = sheetState,
        selectedTabInModalIndex = selectedTabInModalIndex.intValue,
        onCGVTabInModalSelected = { selectedTabInModalIndex.intValue = it },
        selectedRegionInModal = selectedRegionInModal.value,
        onRegionInModalSelected = { selectedRegionInModal.value = it },
        selectedTheaters = selectedTheaters.value,
        onTheaterSelected = {
            if (selectedTheaters.value.contains(it)) selectedTheaters.value -= it
            else selectedTheaters.value += it
        }
    )
}

@Preview
@Composable
fun TimeScreenPreview() {
    TimeScreen()
}