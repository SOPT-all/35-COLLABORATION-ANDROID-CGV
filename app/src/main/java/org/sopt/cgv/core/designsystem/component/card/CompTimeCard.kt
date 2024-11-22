package org.sopt.cgv.core.designsystem.component.card

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.core.designsystem.theme.*
import org.sopt.cgv.R
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import org.sopt.cgv.core.common.norippleclick
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CompTimeCard(
    modifier: Modifier = Modifier,
    startTime: LocalDateTime,
    endTime: LocalDateTime,
    currentSeats: Int,
    totalSeats: Int,
    isMorning: Boolean,
    isActivated: Boolean = false,
    onClick: () -> Unit,
){


    val backgroundColor = if (isActivated) White else Gray700
    val backgroundColor2 = if (isActivated) Gray200 else Gray700
    val leftSeatsColor = if (isActivated) PrimaryRed400 else Green

    val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")
    val formattedStartTime = startTime.format(timeFormatter)
    val formattedEndTime = endTime.format(timeFormatter)

    Box(
        modifier = modifier
            .size(width = 90.dp, height = 64.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .border(width = 1.dp, color = Gray200, shape = RoundedCornerShape(8.dp))
            .clickable {
                onClick()
            }
    ){
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            //시간 부분
            Row(
                modifier = modifier
                    .size(width = 90.dp, height = 41.dp)
                    .padding(horizontal = 8.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ){
                Text(
                    text = formattedStartTime,
                    color = Black,
                    style = Typography.head1_b_16
                )
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = "~$formattedEndTime",
                    color = Gray600,
                    style = Typography.body0_r_8
                )
            }
            //잔여 좌석 부분
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(23.dp)
                    .background(backgroundColor2),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
            ){
                Row(
                    modifier = modifier
                        .padding(top = 3.dp, bottom = 3.dp, start = 9.dp, end = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                ){
                    if(isMorning){
                        Icon(
                            painter = painterResource(id = R.drawable.ic_time_sun),
                            contentDescription = "morning movie",
                            tint = Gray700,
                            modifier = modifier.size(16.dp)
                        )
                    }
                    Text(
                        text = "$currentSeats",
                        color = leftSeatsColor,
                        style = Typography.body2_r_12
                    )
                    Text(
                        text = "/",
                        color = Black,
                        style = Typography.body2_r_12
                    )
                    Text(
                        text = "${totalSeats}석",
                        color = Black,
                        style = Typography.body2_r_12
                    )
                }
            }

        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun CompTimeCardPreview() {
    CompTimeCard(
        modifier = Modifier,
        startTime = LocalDateTime.of(2024, 11, 19, 7, 50),
        endTime = LocalDateTime.of(2024, 11, 19, 9, 41),
        currentSeats = 183,
        totalSeats = 185,
        isMorning = true,
        isActivated = true,
        onClick = {}
    )
}




