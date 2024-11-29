package org.sopt.cgv.feature.seats

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
import org.sopt.cgv.feature.seats.component.TimeCardContent
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import org.sopt.cgv.core.domain.entity.SeatsDetailResponseEntity

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
