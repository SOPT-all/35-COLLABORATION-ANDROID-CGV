package org.sopt.cgv.feature.seats

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.collections.immutable.persistentListOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.encodeToString
import org.sopt.cgv.feature.seats.component.TimeCardContent
import org.sopt.cgv.network.ServicePool
import org.sopt.cgv.network.request.RequestMovieBookingDTO
import org.sopt.cgv.network.response.ResponseMovieBookingDTO
import org.sopt.cgv.network.response.ResponseMovieBookingFailedDTO
import java.time.LocalDateTime

class SeatSelectViewModel : ViewModel() {

    private val SeatService by lazy { ServicePool.SeatService }

    private val _bookingResult = MutableStateFlow<Result<ResponseMovieBookingDTO>?>(null)
    val bookingResult: StateFlow<Result<ResponseMovieBookingDTO>?> = _bookingResult

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

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun bookMovie(movieId: Long) {
        val requestDto = RequestMovieBookingDTO(
            movieName = "글래디에이터 2",
            theaterName = "구리",
            startTime = LocalDateTime.of(2024, 11, 9, 10, 40),
            endTime = LocalDateTime.of(2024, 11, 9, 12, 39),
            ticketCount = 1
        )

        runCatching {
            Log.d("SeatSelectViewModel", "Sending request to server: movieId=$movieId, requestDto=$requestDto")
            SeatService.bookMovie(movieId, requestDto)
        }.onSuccess { response ->
            // HTTP 상태 코드 및 메시지
            Log.d("SeatSelectViewModel", "Response received: code=${response.code()}, message=${response.message()}")

            // JSON 응답 출력
            val responseBody = response.body()
            val errorBody = response.errorBody()?.string()

            if (response.isSuccessful) {
                val successResponse = responseBody ?: throw Exception("응답 바디가 비어있습니다.")
                val rawJson = kotlinx.serialization.json.Json.encodeToString(successResponse)
                Log.d("SeatSelectViewModel", "Success JSON Response: $rawJson")
                _bookingResult.value = Result.success(successResponse)
            } else {
                Log.d("SeatSelectViewModel", "Error JSON Response: $errorBody")

                val errorResponse = errorBody?.let {
                    kotlinx.serialization.json.Json.decodeFromString<ResponseMovieBookingFailedDTO>(it)
                } ?: throw Exception("실패 응답 파싱 실패")

                Log.e("SeatSelectViewModel", "Error parsed response: status=${errorResponse.status}, message=${errorResponse.message}")
                _bookingResult.value = Result.failure(Exception(errorResponse.message))
            }
        }.onFailure { exception ->
            // 예외 출력
            Log.e("SeatSelectViewModel", "Request failed with exception: ${exception.message}", exception)
            _bookingResult.value = Result.failure(exception)
        }
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