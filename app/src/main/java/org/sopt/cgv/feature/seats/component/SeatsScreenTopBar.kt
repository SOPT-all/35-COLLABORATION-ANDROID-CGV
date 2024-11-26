package org.sopt.cgv.feature.seats.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray850
import org.sopt.cgv.core.designsystem.theme.White
import org.sopt.cgv.feature.seats.SeatSelectViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SeatsScreenTopBar(
    modifier: Modifier = Modifier,
    viewModel: SeatSelectViewModel,
    timeCardContent: PersistentList<TimeCardContent>
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Gray850)
            .height(180.dp),
        verticalArrangement = Arrangement.Top
    ){

        Spacer(modifier = Modifier.height(30.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Gray850),
            
        ){
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_back),
                contentDescription = "Go Back",
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(Alignment.CenterStart)
                    .clickable(){

                    }
            )

            Text(
                text = "[IMAX LASER 2D]",
                modifier = Modifier
                    .align(Alignment.Center),
                style = CGVTheme.typography.head4_b_15,
                color = White
            )

        }

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = modifier.height(70.dp)
                .padding(vertical = 1.dp)
        ){
            SeatSelectionTimeCardRow(viewModel = viewModel, contents = timeCardContent)
        }


    }

}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun SeatsScreenTopBarPreview(){

    val sampleTimeCardData = persistentListOf(
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

    SeatsScreenTopBar(
        modifier = Modifier,
        viewModel = SeatSelectViewModel(),
        timeCardContent = sampleTimeCardData
    )
}