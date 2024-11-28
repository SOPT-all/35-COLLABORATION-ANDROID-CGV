package org.sopt.cgv.feature.time

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.cgv.core.designsystem.theme.White
import org.sopt.cgv.feature.time.component.TheaterSelectionModalBottomSheet
import org.sopt.cgv.feature.time.component.TimeScreenAuditorioumAndTimeSelection
import org.sopt.cgv.feature.time.component.TimeScreenDateSelectionTab
import org.sopt.cgv.feature.time.component.TimeScreenMovieSelectionSection
import org.sopt.cgv.feature.time.component.TimeScreenTimeSelectionHeader
import org.sopt.cgv.feature.time.component.TimeScreenTobBar

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun TimeScreen(
    selectedTabInModalIndex: Int,
    onCGVTabInModalSelected: (Int) -> Unit,
    selectedRegionInModal: String,
    onRegionInModalSelected: (String) -> Unit,
    selectedTheaters: Set<String>,
    onTheaterSelected: (String) -> Unit,
    selectedTimeScreenTobBarTabIndex: Int,
    onTimeScreenTobBarTabSelected: (Int) -> Unit,
    @DrawableRes selectedPoster: Int,
    onPosterSelected: (Int) -> Unit,
    selectedDate: String,
    onDateSelected: (String) -> Unit,
    selectedDay: String,
    onDaySelected: (String) -> Unit,
    isSheetOpen: Boolean,
    onSheetStateChanged: () -> Unit,
    modifier: Modifier = Modifier
) {

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            TimeScreenTobBar(
                selectedTimeScreenTobBarTabIndex = selectedTimeScreenTobBarTabIndex,
                onTimeScreenTobBarTabSelected = onTimeScreenTobBarTabSelected
            )
        }
    ) { innerPadding ->
        CompositionLocalProvider(
            LocalOverscrollConfiguration provides null
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(White)
            ) {
                item {
                    TimeScreenMovieSelectionSection(
                        selectedPoster = selectedPoster,
                        onPosterSelected = onPosterSelected
                    )
                }

                stickyHeader {
                    TimeScreenDateSelectionTab(
                        selectedDate = selectedDate,
                        onDateSelected = onDateSelected,
                        selectedDay = selectedDay,
                        onDaySelected = onDaySelected
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(22.dp)
                            .background(White)
                    )

                    TimeScreenTimeSelectionHeader(
                        onSheetStateChanged = onSheetStateChanged,
                        numberOfSelectedTheaters = selectedTheaters.size
                    )
                }

                item {
                    TimeScreenAuditorioumAndTimeSelection(
                        selectedTheaters = selectedTheaters
                    )
                }
            }
        }
    }

    TheaterSelectionModalBottomSheet(
        isSheetOpen = isSheetOpen,
        onDismissRequest = onSheetStateChanged,
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
        selectedTabInModalIndex = selectedTabInModalIndex,
        onCGVTabInModalSelected = onCGVTabInModalSelected,
        selectedRegionInModal = selectedRegionInModal,
        onRegionInModalSelected = onRegionInModalSelected,
        selectedTheaters = selectedTheaters,
        onTheaterSelected = onTheaterSelected
    )
}

@Preview
@Composable
fun TimeScreenPreview() {
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