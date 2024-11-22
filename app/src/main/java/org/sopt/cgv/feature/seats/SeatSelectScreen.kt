package org.sopt.cgv.feature.seats

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.core.designsystem.theme.Gray800
import java.time.LocalDateTime
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.theme.Gray850
import org.sopt.cgv.core.designsystem.theme.Gray900


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SeatSelectScreen(
    modifier: Modifier = Modifier,
){

    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = modifier,
    ){
        innerPadding ->
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
                painter = painterResource(id = R.drawable.img_seats1_unselected),
                contentDescription = "좌석표",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )


        }
    }


}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun SeatSelectScreenPreview(){
    SeatSelectScreen(
        modifier = Modifier,

    )
}