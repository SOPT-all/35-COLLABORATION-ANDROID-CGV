package org.sopt.cgv.feature.seats.component

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.collections.immutable.persistentListOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class SeatSelectViewModel : ViewModel() {

    var showBottomSheet by mutableStateOf(true)
    var isSeatSelected by mutableStateOf(false)
    var showSeatConfirmBottomSheet by mutableStateOf(false)

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