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
import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.launch
import org.sopt.cgv.core.data.repository.CgvRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.encodeToString
import org.sopt.cgv.feature.seats.component.TimeCardContent
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import org.sopt.cgv.core.domain.entity.SeatsDetailResponseEntity
import org.sopt.cgv.network.ServicePool
import org.sopt.cgv.network.ServicePool.seatService
import org.sopt.cgv.network.request.RequestMovieBookingDTO
import org.sopt.cgv.network.response.ResponseMovieBookingDTO
import org.sopt.cgv.network.response.ResponseMovieBookingFailedDTO
import java.time.LocalDateTime

class SeatSelectViewModel(
    private val repository: CgvRepository
) : ViewModel() {
    private val _timeCardData = mutableStateOf<PersistentList<TimeCardContent>>(persistentListOf())
    val timeCardData: PersistentList<TimeCardContent> get() = _timeCardData.value

    private val _movieTitle = mutableStateOf("")
    val movieTitle: String get() = _movieTitle.value

    private val _chipContents = mutableStateOf<PersistentList<String>>(persistentListOf())
    val chipContents: PersistentList<String> get() = _chipContents.value


    var selectedSeatUrl by mutableStateOf("")

    private val _clickedTimeCardIndex = mutableIntStateOf(0)
    val clickedTimeCardIndex: State<Int> = _clickedTimeCardIndex

    private val _selectedTimeInfo = mutableStateOf("")

    fun fetchMovieDetails(movieId: Long) {
        viewModelScope.launch {
            repository.getSeatsDetail(movieId)
                .onSuccess { movieList ->
                    movieList.firstOrNull()?.let { movie ->
                        updateMovieDetails(movie, movieList)
                    } ?: handleEmptyMovieData()
                }
                .onFailure { error ->
                    error.printStackTrace()
                }
        }
    }

    private fun updateMovieDetails(
        movie: SeatsDetailResponseEntity,
        movieList: List<SeatsDetailResponseEntity>
    ) {
        _movieTitle.value = movie.name
        _timeCardData.value = createTimeCardList(movieList)
        _chipContents.value = createChipContents(movie)

        if (_timeCardData.value.isNotEmpty()) {
            selectedSeatUrl = movieList.first().seatAnd
            val firstMovie = movieList.first()
            _selectedTimeInfo.value =
                "${firstMovie.startTime.substring(11, 16)} ~ ${firstMovie.endTime.substring(11,16)}"
        }
    }

    private fun createTimeCardList(movieList: List<SeatsDetailResponseEntity>) =
        movieList.mapIndexed { index, movie ->
            TimeCardContent(
                startTime = movie.startTime.substring(11, 16),
                endTime = movie.endTime.substring(11, 16),
                currentSeats = 173,
                totalSeats = 185,
                isMorning = movie.isMorning,
                isActivated = index == 0,
                seatAnd = movie.seatAnd
            )
        }.toPersistentList()

    private fun createChipContents(movie: SeatsDetailResponseEntity) =
        persistentListOf(
            movie.releaseDate,
            movie.theaterName,
            "${movie.startTime.substring(11, 16)} ~ ${movie.endTime.substring(11, 16)}"
        )

    private fun handleEmptyMovieData() {
        _movieTitle.value = "Unknown Movie"
        _timeCardData.value = persistentListOf()
        _chipContents.value = persistentListOf()
    }

    fun updateClickedTimeCardIndex(index: Int) {
        _clickedTimeCardIndex.intValue = index
        if (index in timeCardData.indices) {
            val selectedTimeCard = timeCardData[index]
            _selectedTimeInfo.value = "${selectedTimeCard.startTime} ~ ${selectedTimeCard.endTime}"
            _chipContents.value = persistentListOf(
                _chipContents.value[0],
                _chipContents.value[1],
                _selectedTimeInfo.value
            )
        }
    }

    fun updateSelectedSeatUrl(index: Int) {
        if (index in timeCardData.indices) {
            selectedSeatUrl = timeCardData[index].seatAnd
        }
    }

    private val seatService by lazy { ServicePool.seatService }

    private val _bookingResult = MutableStateFlow<Result<ResponseMovieBookingDTO>?>(null)
    val bookingResult: StateFlow<Result<ResponseMovieBookingDTO>?> = _bookingResult

    var showBottomSheet by mutableStateOf(true)
    fun toggleBottomSheet() {
        showBottomSheet = !showBottomSheet
    }

    var isSeatSelected by mutableStateOf(false)
        private set

    fun toggleSeat() {
        isSeatSelected = !isSeatSelected
    }

    var showSeatConfirmBottomSheet by mutableStateOf(false)
    fun toggleSeatConfirmBottomSheet() {
        showSeatConfirmBottomSheet = !showSeatConfirmBottomSheet
        if (!showSeatConfirmBottomSheet) {
            isSeatSelected = false
        }
    }

    private val _stepperValues = mutableStateListOf(0, 0, 0, 0)
    val stepperValues: List<Int> get() = _stepperValues
    fun increaseStepperValue(index: Int) {
        _stepperValues[index] = _stepperValues[index] + 1
    }

    fun decreaseStepperValue(index: Int) {
        if (_stepperValues[index] > 0) {
            _stepperValues[index] = _stepperValues[index] - 1
        }
    }

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
            seatService.bookMovie(movieId, requestDto)
        }.onSuccess { response ->
            val responseBody = response.body()
            val errorBody = response.errorBody()?.string()

            if (response.isSuccessful) {
                val successResponse = responseBody ?: throw Exception("응답 바디가 비어있습니다.")
            } else {
                Log.d("SeatSelectViewModel", "Error JSON Response: $errorBody")
                val errorResponse = errorBody?.let {
                    kotlinx.serialization.json.Json.decodeFromString<ResponseMovieBookingFailedDTO>(it)
                } ?: throw Exception("실패 응답 파싱 실패")
            }
        }.onFailure { exception ->
            Log.e("SeatSelectViewModel", "Request failed with exception: ${exception.message}", exception)
        }
    }


