package org.sopt.cgv.feature.seats

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.collections.immutable.persistentListOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import org.sopt.cgv.feature.seats.component.TimeCardContent

class SeatSelectViewModel : ViewModel() {

    var showBottomSheet by mutableStateOf(true)
    var isSeatSelected by mutableStateOf(false)
        private set
    var showSeatConfirmBottomSheet by mutableStateOf(false)

    var clickedTimeCardIndex by mutableStateOf(-1)

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

    fun setClickedCardIndex(index: Int) {
        clickedTimeCardIndex = index
    }

    fun toggleBottomSheet(){
        showBottomSheet = !showBottomSheet
    }

    fun toggleSeat(){
        isSeatSelected = !isSeatSelected
    }

    fun toggleSeatConfirmBottomSheet(){
        showSeatConfirmBottomSheet = !showSeatConfirmBottomSheet
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