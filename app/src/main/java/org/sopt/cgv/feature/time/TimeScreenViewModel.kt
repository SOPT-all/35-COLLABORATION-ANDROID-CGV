package org.sopt.cgv.feature.time

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.cgv.network.ServicePool

class TimeScreenViewModel : ViewModel() {
    private val timeService by lazy { ServicePool.timeService() }

    private val _timeScreenState = MutableStateFlow(TimeScreenState())
    val timeScreenState: StateFlow<TimeScreenState> = _timeScreenState.asStateFlow()

    private val _timeModalState = MutableStateFlow(TimeModalState())
    val timeModalState: StateFlow<TimeModalState> = _timeModalState.asStateFlow()

    fun onTimeScreenTobBarTabSelected(selectedIndex: Int) {
        _timeScreenState.value = _timeScreenState.value.copy(
            tobBarTabIndex = selectedIndex
        )
    }

    fun onPosterSelected(@DrawableRes selectedPoster: Int) {
        _timeScreenState.value = _timeScreenState.value.copy(
            poster = selectedPoster
        )
    }

    fun onDateSelected(selectedDate: String) {
        _timeScreenState.value = _timeScreenState.value.copy(
            date = selectedDate
        )
    }

    fun onDaySelected(selectedDay: String) {
        _timeScreenState.value = _timeScreenState.value.copy(
            day = selectedDay
        )
    }

    fun onSheetStateChanged() {
        _timeModalState.value = _timeModalState.value.copy(
            isSheetOpen = !_timeModalState.value.isSheetOpen
        )
    }

    fun onCGVTabInModalSelected(selectedIndex: Int) {
        _timeModalState.value = _timeModalState.value.copy(
            tabIndex = selectedIndex
        )
    }

    fun onRegionInModalSelected(selectedRegion: String) {
        _timeModalState.value = _timeModalState.value.copy(
            region = selectedRegion
        )
    }

    fun onTheaterSelected(selectedTheater: String) {
        if (_timeModalState.value.theaters.contains(selectedTheater))
            _timeModalState.value = _timeModalState.value.copy(
                theaters = _timeModalState.value.theaters.minus(selectedTheater)
            )
        else _timeModalState.value = _timeModalState.value.copy(
            theaters = _timeModalState.value.theaters.plus(selectedTheater)
        )
    }

    fun getTheaters() {
        viewModelScope.launch {
            runCatching {
                timeService.getTheaters()
            }.onSuccess { theaterResponse ->
                Log.d("service", theaterResponse.toString())
                _timeModalState.value =
                    _timeModalState.value.copy(theaterList = theaterResponse.data)
            }.onFailure { error ->
                Log.e("service", error.toString())
            }
        }
    }

    fun getTimeTables(
        theaterId: Int,
        auditorium: String,
        auditoriumType: String
    ) {
        viewModelScope.launch {
            runCatching {
                timeService.getTimeTables(
                    theaterId = theaterId,
                    auditorium = auditorium,
                    auditoriumType = auditoriumType
                )
            }.onSuccess { timeTableResponse ->
                Log.d("ㅋㅋ", timeTableResponse.toString())
                _timeScreenState.value =
                    _timeScreenState.value.copy(timeTableList = _timeScreenState.value.timeTableList + timeTableResponse.data.movieList)
            }.onFailure { error ->
                Log.e("ㅋㅋ", error.toString())
            }
        }
    }

    fun initTimeTableList() {
        _timeScreenState.value = _timeScreenState.value.copy(timeTableList = listOf())
    }
}