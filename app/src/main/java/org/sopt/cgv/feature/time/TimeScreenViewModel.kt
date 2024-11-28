package org.sopt.cgv.feature.time

import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TimeScreenViewModel : ViewModel() {
    private val _timeScreenState = MutableStateFlow(TimeScreenState())
    val timeScreenState: StateFlow<TimeScreenState> = _timeScreenState.asStateFlow()

    fun onTimeScreenTobBarTabSelected(selectedIndex: Int) {
        _timeScreenState.value = _timeScreenState.value.copy(
            selectedTimeScreenTobBarTabIndex = selectedIndex
        )
    }

    fun onPosterSelected(@DrawableRes selectedPoster: Int) {

        _timeScreenState.value = _timeScreenState.value.copy(
            selectedPoster = selectedPoster
        )

    }

    fun onDateSelected(selectedDate: String) {
        _timeScreenState.value = _timeScreenState.value.copy(
            selectedDate = selectedDate
        )
    }

    fun onDaySelected(selectedDay: String) {
        _timeScreenState.value = _timeScreenState.value.copy(
            selectedDay = selectedDay
        )
    }

    fun onSheetStateChanged() {
        _timeScreenState.value = _timeScreenState.value.copy(
            isSheetOpen = !_timeScreenState.value.isSheetOpen
        )
    }

    fun onCGVTabInModalSelected(selectedIndex: Int) {
        _timeScreenState.value = _timeScreenState.value.copy(
            selectedTabInModalIndex = selectedIndex
        )
    }

    fun onRegionInModalSelected(selectedRegion: String) {
        _timeScreenState.value = _timeScreenState.value.copy(
            selectedRegionInModal = selectedRegion
        )
    }

    fun onTheaterSelected(selectedTheater: String) {
        if (_timeScreenState.value.selectedTheaters.contains(selectedTheater))
            _timeScreenState.value = _timeScreenState.value.copy(
                selectedTheaters = _timeScreenState.value.selectedTheaters.minus(selectedTheater)
            )
        else _timeScreenState.value = _timeScreenState.value.copy(
            selectedTheaters = _timeScreenState.value.selectedTheaters.plus(selectedTheater)
        )
    }
}