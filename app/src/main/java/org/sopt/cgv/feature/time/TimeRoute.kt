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
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.core.designsystem.theme.White
import org.sopt.cgv.feature.time.component.TheaterSelectionModalBottomSheet
import org.sopt.cgv.feature.time.component.TimeScreenAuditorioumAndTimeSelection
import org.sopt.cgv.feature.time.component.TimeScreenDateSelectionTab
import org.sopt.cgv.feature.time.component.TimeScreenMovieSelectionSection
import org.sopt.cgv.feature.time.component.TimeScreenTimeSelectionHeader
import org.sopt.cgv.feature.time.component.TimeScreenTobBar
import org.sopt.cgv.feature.time.data.Theater
import org.sopt.cgv.feature.time.data.TimeTable

@Composable
fun TimeRoute(
    navigateToSeat: () -> Unit,
    timeScreenViewModel: TimeScreenViewModel
) {
    val timeScreenState by timeScreenViewModel.timeScreenState.collectAsStateWithLifecycle()
    val timeModalState by timeScreenViewModel.timeModalState.collectAsStateWithLifecycle()

    TimeScreen(
        selectedTabInModalIndex = timeModalState.tabIndex,
        onCGVTabInModalSelected = timeScreenViewModel::onCGVTabInModalSelected,
        selectedRegionInModal = timeModalState.region,
        onRegionInModalSelected = timeScreenViewModel::onRegionInModalSelected,
        selectedTheaters = timeModalState.theaters,
        onTheaterSelected = timeScreenViewModel::onTheaterSelected,
        selectedTimeScreenTobBarTabIndex = timeScreenState.tobBarTabIndex,
        onTimeScreenTobBarTabSelected = timeScreenViewModel::onTimeScreenTobBarTabSelected,
        selectedPoster = timeScreenState.poster,
        onPosterSelected = timeScreenViewModel::onPosterSelected,
        selectedDate = timeScreenState.date,
        onDateSelected = timeScreenViewModel::onDateSelected,
        selectedDay = timeScreenState.day,
        onDaySelected = timeScreenViewModel::onDaySelected,
        isSheetOpen = timeModalState.isSheetOpen,
        onSheetStateChanged = timeScreenViewModel::onSheetStateChanged,
        navigateToSeat = navigateToSeat,
        theaterList = timeModalState.theaterList,
        getTheaters = timeScreenViewModel::getTheaters,
        timeTableList = timeScreenState.timeTableList,
        getTimeTables = timeScreenViewModel::getTimeTables,
        initTimeTableList = timeScreenViewModel::initTimeTableList
    )
}

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
    navigateToSeat: () -> Unit,
    theaterList: PersistentList<Theater>,
    getTheaters: () -> Unit,
    timeTableList: PersistentList<TimeTable>,
    getTimeTables: (Int, String, String) -> Unit,
    initTimeTableList: () -> Unit,
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
                        numberOfSelectedTheaters = selectedTheaters.size,
                        initTimeTableList = initTimeTableList
                    )
                }

                item {
                    TimeScreenAuditorioumAndTimeSelection(
                        selectedTheaters = selectedTheaters,
                        timeTableList = timeTableList,
                        theaterList = theaterList,
                        navigateToSeat = navigateToSeat
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
        onTheaterSelected = onTheaterSelected,
        theaterList = theaterList,
        getTimeTables = getTimeTables,
        getTheaters = getTheaters
    )
}

@Preview
@Composable
fun TimeScreenPreview() {
    val timeScreenViewModel = viewModel<TimeScreenViewModel>()
    val timeScreenState by timeScreenViewModel.timeScreenState.collectAsStateWithLifecycle()
    val timeModalState by timeScreenViewModel.timeModalState.collectAsStateWithLifecycle()

    TimeScreen(
        selectedTabInModalIndex = timeModalState.tabIndex,
        onCGVTabInModalSelected = timeScreenViewModel::onCGVTabInModalSelected,
        selectedRegionInModal = timeModalState.region,
        onRegionInModalSelected = timeScreenViewModel::onRegionInModalSelected,
        selectedTheaters = timeModalState.theaters,
        onTheaterSelected = timeScreenViewModel::onTheaterSelected,
        selectedTimeScreenTobBarTabIndex = timeScreenState.tobBarTabIndex,
        onTimeScreenTobBarTabSelected = timeScreenViewModel::onTimeScreenTobBarTabSelected,
        selectedPoster = timeScreenState.poster,
        onPosterSelected = timeScreenViewModel::onPosterSelected,
        selectedDate = timeScreenState.date,
        onDateSelected = timeScreenViewModel::onDateSelected,
        selectedDay = timeScreenState.day,
        onDaySelected = timeScreenViewModel::onDaySelected,
        isSheetOpen = timeModalState.isSheetOpen,
        onSheetStateChanged = timeScreenViewModel::onSheetStateChanged,
        theaterList = persistentListOf(),
        getTheaters = {},
        timeTableList = persistentListOf(),
        getTimeTables = { _, _, _ -> },
        initTimeTableList = {},
        navigateToSeat = {}
    )
}