package org.sopt.cgv.feature.seats

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.collections.immutable.persistentListOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import org.sopt.cgv.feature.seats.component.TimeCardContent

class SeatSelectViewModel : ViewModel() {

    var showBottomSheet by mutableStateOf(true)
    fun toggleBottomSheet(){
        showBottomSheet = !showBottomSheet
    }

    var isSeatSelected by mutableStateOf(false)
        private set
    fun toggleSeat(){
        isSeatSelected = !isSeatSelected
    }
    var showSeatConfirmBottomSheet by mutableStateOf(false)
    fun toggleSeatConfirmBottomSheet(){
        showSeatConfirmBottomSheet = !showSeatConfirmBottomSheet
    }

    private val _stepperValues = mutableStateListOf(0, 0, 0, 0)
    val stepperValues: List<Int> get() = _stepperValues
    fun increaseStepperValue(index: Int){
        _stepperValues[index] = _stepperValues[index] + 1
    }
    fun decreaseStepperValue(index: Int){
        if(_stepperValues[index] > 0){
            _stepperValues[index] = _stepperValues[index] - 1
        }
    }

    private val _clickedTimeCardIndex = mutableStateOf(-1)
    val clickedTimeCardIndex: MutableState<Int> get() = _clickedTimeCardIndex
    fun setClickedTimeCardIndex(index: Int) {
        _clickedTimeCardIndex.value = index
    }

    val chipContents = persistentListOf(
        "2024.11.05 (월)",
        "구리",
        "10:40 ~ 12:39"
    )

    val sampleTimeCardData = persistentListOf(
        TimeCardContent(
            startTime = "07:50",
            endTime = "09:51",
            currentSeats = 185,
            totalSeats = 178,
            isMorning = true,
            isActivated = true,
        ),
        TimeCardContent(
            startTime = "07:50",
            endTime = "09:51",
            currentSeats = 185,
            totalSeats = 178,
            isMorning = true,
            isActivated = false,
        ),
        TimeCardContent(
            startTime = "07:50",
            endTime = "09:51",
            currentSeats = 185,
            totalSeats = 178,
            isMorning = true,
            isActivated = false,
        ),
        TimeCardContent(
            startTime = "07:50",
            endTime = "09:51",
            currentSeats = 185,
            totalSeats = 178,
            isMorning = false,
            isActivated = false,
        ),
        TimeCardContent(
            startTime = "07:50",
            endTime = "09:51",
            currentSeats = 185,
            totalSeats = 178,
            isMorning = false,
            isActivated = false,
        ),
        TimeCardContent(
            startTime = "07:50",
            endTime = "09:51",
            currentSeats = 185,
            totalSeats = 178,
            isMorning = false,
            isActivated = false,
        )
    )
}