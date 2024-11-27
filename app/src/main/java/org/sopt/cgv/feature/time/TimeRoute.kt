package org.sopt.cgv.feature.time

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TimeRoute(
    navigateToSeat: () -> Unit
) {
    val timeScreenViewModel = viewModel<TimeScreenViewModel>()
    val timeScreenUiState by timeScreenViewModel.uiState.collectAsStateWithLifecycle()

    TimeScreen(
        selectedTabInModalIndex = timeScreenUiState.selectedTabInModalIndex,
        onCGVTabInModalSelected = timeScreenViewModel::onCGVTabInModalSelected,
        selectedRegionInModal = timeScreenUiState.selectedRegionInModal,
        onRegionInModalSelected = timeScreenViewModel::onRegionInModalSelected,
        selectedTheaters = timeScreenUiState.selectedTheaters,
        onTheaterSelected = timeScreenViewModel::onTheaterSelected,
        selectedTimeScreenTobBarTabIndex = timeScreenUiState.selectedTimeScreenTobBarTabIndex,
        onTimeScreenTobBarTabSelected = timeScreenViewModel::onTimeScreenTobBarTabSelected,
        selectedPoster = timeScreenUiState.selectedPoster,
        onPosterSelected = timeScreenViewModel::onPosterSelected,
        selectedDate = timeScreenUiState.selectedDate,
        onDateSelected = timeScreenViewModel::onDateSelected,
        selectedDay = timeScreenUiState.selectedDay,
        onDaySelected = timeScreenViewModel::onDaySelected,
        isSheetOpen = timeScreenUiState.isSheetOpen,
        onSheetStateChanged = timeScreenViewModel::onSheetStateChanged
    )
}