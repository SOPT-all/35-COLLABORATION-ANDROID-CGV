package org.sopt.cgv.core.designsystem.component.card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import org.sopt.cgv.R
import org.sopt.cgv.core.common.extension.noRippleClickable
import org.sopt.cgv.core.designsystem.theme.Black
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray200
import org.sopt.cgv.core.designsystem.theme.Gray600
import org.sopt.cgv.core.designsystem.theme.Gray700
import org.sopt.cgv.core.designsystem.theme.Green
import org.sopt.cgv.core.designsystem.theme.PrimaryRed400
import org.sopt.cgv.core.designsystem.theme.White

@Composable
fun CompTimeCard(
    modifier: Modifier = Modifier,
    startTime: String,
    endTime: String,
    currentSeats: Int,
    totalSeats: Int,
    isMorning: Boolean,
    isActivated: Boolean = false,
    isInTime: Boolean = false,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .fillMaxHeight()
            .aspectRatio(1.4f)
            .clip(RoundedCornerShape(8.dp))
            .background(if (isActivated) White else Gray700)
            .border(width = 1.dp, color = Gray200, shape = RoundedCornerShape(8.dp))
            .noRippleClickable {
                onClick()
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = startTime,
                    color = Black,
                    style = CGVTheme.typography.head1_b_16
                )
                Spacer(modifier = Modifier.width(1.dp))
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = "~${endTime}",
                    color = Gray600,
                    style = CGVTheme.typography.body1_r_10
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(if (isActivated) Gray200 else Gray700),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(if (isActivated) Gray200 else Gray700)
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    if (isMorning) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_time_sun),
                            contentDescription = "morning movie",
                            tint = Gray700,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    Text(
                        text = "$currentSeats",
                        color = if (isActivated && isInTime) Green else if (isActivated) PrimaryRed400 else Green,
                        style = CGVTheme.typography.body2_r_12
                    )
                    Text(
                        text = "/",
                        color = Black,
                        style = CGVTheme.typography.body2_r_12
                    )
                    Text(
                        text = "${totalSeats}석",
                        color = Black,
                        style = CGVTheme.typography.body2_r_12
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CompTimeCardPreview() {
    Column(
        modifier = Modifier.height(70.dp)
    ) {
        CompTimeCard(
            modifier = Modifier,
            startTime = "07:50",
            endTime = "09:41",
            currentSeats = 183,
            totalSeats = 185,
            isMorning = true,
            isActivated = true,
            onClick = {}
        )
    }
}