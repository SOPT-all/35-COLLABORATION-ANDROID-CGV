package org.sopt.cgv.feature.seats

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.collections.immutable.persistentListOf
import java.time.LocalDateTime
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.theme.Gray900


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SeatSelectScreen(
    modifier: Modifier = Modifier,
    showBottomSheet: Boolean = true,
    movieTitle: String,
    chipContents: List<String>,
){

    val scrollState = rememberScrollState()

    var _showBottomSheet by remember { mutableStateOf(showBottomSheet) }
    var showSeatConfirmBottomSheet by remember { mutableStateOf(false) }

    var isSeatSelected by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier,
    ){  innerPadding ->

        if (_showBottomSheet) {
            SeatSelectionModal1(
                modifier = Modifier,
                movieTitle = movieTitle,
                chipContents = chipContents,
                onBackClick = { _showBottomSheet = false },
                onSeatSelectionClick = { _showBottomSheet = false }
            )
        }

        if (showSeatConfirmBottomSheet){
            SeatConfirmationModal(
                modifier = Modifier,
                movieTitle = "글래디에이터 2",
                chipContents = chipContents,
                onBackClick = { showSeatConfirmBottomSheet = false },
                onSeatSelectionClick = { showSeatConfirmBottomSheet = false }
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(Gray900)
                .padding(innerPadding)
        ){
            val sampleTimeCardData = persistentListOf(
                TimeCardContent(
                    startTime = LocalDateTime.of(2024, 11, 19, 7, 50),
                    endTime = LocalDateTime.of(2024, 11, 19, 9, 41),
                    currentSeats = 185,
                    totalSeats = 178,
                    isMorning = true,
                    isActivated = false,
                ),
                TimeCardContent(
                    startTime = LocalDateTime.of(2024, 11, 19, 7, 50),
                    endTime = LocalDateTime.of(2024, 11, 19, 9, 41),
                    currentSeats = 185,
                    totalSeats = 178,
                    isMorning = true,
                    isActivated = false,
                ),
                TimeCardContent(
                    startTime = LocalDateTime.of(2024, 11, 19, 7, 50),
                    endTime = LocalDateTime.of(2024, 11, 19, 9, 41),
                    currentSeats = 185,
                    totalSeats = 178,
                    isMorning = true,
                    isActivated = false,
                ),
                TimeCardContent(
                    startTime = LocalDateTime.of(2024, 11, 19, 7, 50),
                    endTime = LocalDateTime.of(2024, 11, 19, 9, 41),
                    currentSeats = 185,
                    totalSeats = 178,
                    isMorning = false,
                    isActivated = false,
                ),
                TimeCardContent(
                    startTime = LocalDateTime.of(2024, 11, 19, 7, 50),
                    endTime = LocalDateTime.of(2024, 11, 19, 9, 41),
                    currentSeats = 185,
                    totalSeats = 178,
                    isMorning = false,
                    isActivated = false,
                ),
                TimeCardContent(
                    startTime = LocalDateTime.of(2024, 11, 19, 7, 50),
                    endTime = LocalDateTime.of(2024, 11, 19, 9, 41),
                    currentSeats = 185,
                    totalSeats = 178,
                    isMorning = false,
                    isActivated = false,
                )
            )

            SeatsScreenTopBar(
                modifier = Modifier,
                timeCardContent = sampleTimeCardData
            )

            Image(
                painter = painterResource(
                    id = if (isSeatSelected){
                        R.drawable.img_seats1_selected
                    } else {
                        R.drawable.img_seats1_unselected
                    }
                ),
                contentDescription = "좌석표",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        isSeatSelected = !isSeatSelected
                        showSeatConfirmBottomSheet = true
                    },
                contentScale = ContentScale.Crop
            )


        }
    }


}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun SeatSelectScreenPreview(){

    val ChipContents = listOf(
        "2024.11.05 (월)",
        "구리",
        "10:40 ~ 12:39"
    )

    SeatSelectScreen(
        modifier = Modifier,
        movieTitle = "글래디에이터 2",
        chipContents = ChipContents
    )
}