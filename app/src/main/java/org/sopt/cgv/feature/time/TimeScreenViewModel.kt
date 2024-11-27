package org.sopt.cgv.feature.time

import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TimeScreenViewModel() : ViewModel() {
    private val _timeScreenUiState = MutableStateFlow(TimeScreenUiState())
    val uiState: StateFlow<TimeScreenUiState> = _timeScreenUiState.asStateFlow()

    fun onTimeScreenTobBarTabSelected(selectedIndex: Int) {
        if (_timeScreenUiState.value.selectedTimeScreenTobBarTabIndex != selectedIndex) {
            _timeScreenUiState.value = _timeScreenUiState.value.copy(
                selectedTimeScreenTobBarTabIndex = selectedIndex
            )
        }
    }

    fun onPosterSelected(@DrawableRes selectedPoster: Int) {
        if (_timeScreenUiState.value.selectedPoster != selectedPoster) {
            _timeScreenUiState.value = _timeScreenUiState.value.copy(
                selectedPoster = selectedPoster
            )
        }
    }

    fun onDateSelected(selectedDate: String) {
        if (_timeScreenUiState.value.selectedDate != selectedDate) {
            _timeScreenUiState.value = _timeScreenUiState.value.copy(
                selectedDate = selectedDate
            )
        }
    }

    fun onDaySelected(selectedDay: String) {
        if (_timeScreenUiState.value.selectedDay != selectedDay) {
            _timeScreenUiState.value = _timeScreenUiState.value.copy(
                selectedDay = selectedDay
            )
        }
    }

    fun onSheetStateChanged() {
        _timeScreenUiState.value = _timeScreenUiState.value.copy(
            isSheetOpen = !_timeScreenUiState.value.isSheetOpen
        )
    }

    fun onCGVTabInModalSelected(selectedIndex: Int) {
        if (_timeScreenUiState.value.selectedTabInModalIndex != selectedIndex) {
            _timeScreenUiState.value = _timeScreenUiState.value.copy(
                selectedTabInModalIndex = selectedIndex
            )
        }
    }

    fun onRegionInModalSelected(selectedRegion: String) {
        if (_timeScreenUiState.value.selectedRegionInModal != selectedRegion) {
            _timeScreenUiState.value = _timeScreenUiState.value.copy(
                selectedRegionInModal = selectedRegion
            )
        }
    }

    fun onTheaterSelected(selectedTheater: String) {
        if (_timeScreenUiState.value.selectedTheaters.contains(selectedTheater))
            _timeScreenUiState.value = _timeScreenUiState.value.copy(
                selectedTheaters = _timeScreenUiState.value.selectedTheaters.minus(selectedTheater)
            )
        else _timeScreenUiState.value = _timeScreenUiState.value.copy(
            selectedTheaters = _timeScreenUiState.value.selectedTheaters.plus(selectedTheater)
        )
    }
}