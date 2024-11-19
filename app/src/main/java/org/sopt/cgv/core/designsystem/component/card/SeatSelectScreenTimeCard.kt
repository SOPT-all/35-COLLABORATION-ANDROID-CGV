package org.sopt.cgv.core.designsystem.component.card

import org.sopt.cgv.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.cgv.ui.theme.Black
import org.sopt.cgv.ui.theme.Gray200
import org.sopt.cgv.ui.theme.Gray600
import org.sopt.cgv.ui.theme.Gray700
import org.sopt.cgv.ui.theme.White

@Composable
fun SeatSelectScreenTimeCard(
    startTime: String,
    endTime: String,
    currentSeats: Int,
    totalSeats: Int,
    isMorning: Boolean
){
    Box(
        modifier = Modifier
            .size(width = 90.dp, height = 64.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(White)
            .border(width = 2.dp, color = Gray200, shape = RoundedCornerShape(8.dp))

    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            //시간 부분
            Row(
                modifier = Modifier
                    .size(width = 90.dp, height = 41.dp)
                    .padding(horizontal = 8.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = startTime,
                    color = Black,
                    fontSize = 18.sp
                )
                Text(
                    modifier = Modifier
                        .padding(top = 6.dp),
                    text = "~$endTime",
                    color = Gray600,
                    fontSize = 8.sp
                )
            }
            //잔여 좌석 부분
            Column(
                modifier = Modifier
                    .size(width = 90.dp, height = 23.dp)
                    .background(Gray200)
                    .padding(horizontal = 3.dp, vertical = 2.dp),
                verticalArrangement = Arrangement.Center
            ){
                Row(
                    modifier = Modifier
                        .padding(vertical = 3.dp, horizontal = 9.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        painter = painterResource(id = R.drawable.ic_time_sun),
                        contentDescription = "morning movie",
                        tint = Gray700,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${currentSeats}/${totalSeats}석",
                        color = Black,
                        fontSize = 10.sp
                    )
                }
            }

        }


    }

}

@Preview(showBackground = true)
@Composable
fun SeatSelectScreenTimeCardPreview() {
    SeatSelectScreenTimeCard(
        startTime = "07:50",
        endTime = "09:41",
        currentSeats = 183,
        totalSeats = 185,
        isMorning = true
    )
}




