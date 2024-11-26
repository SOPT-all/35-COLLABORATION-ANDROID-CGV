package org.sopt.cgv.feature.time.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.core.designsystem.component.card.CompTimeCard
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray600

@Composable
fun TimeScreenAuditorioumAndTimeSelection() {

}

@Composable
fun TimeScreenAuditoriumAndTimeInTheater() {

}

@Composable
fun TimeScreenTimeInAuditorium() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "IMAX LASER 2D",
                style = CGVTheme.typography.head1_b_12,
                color = Gray600
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "7관",
                style = CGVTheme.typography.body1_m_12,
                color = Gray600
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
             items(count = 5) {
                 Column(modifier = Modifier.height(70.dp)) {
                     CompTimeCard(
                         startTime = "07:50",
                         endTime = "09:41",
                         currentSeats = 183,
                         totalSeats = 185,
                         isMorning = false,
                         isActivated = true
                     ) { }
                 }
             }
        }
    }
}

@Preview
@Composable
private fun TimeScreenTimeAuditorioumAndTimeSelectionPreview() {
    TimeScreenAuditorioumAndTimeSelection()
}

@Preview
@Composable
private fun TimeScreenAuditorioumAndTimeInTheaterPreview() {
    TimeScreenAuditoriumAndTimeInTheater()
}

@Preview
@Composable
private fun TimeScreenTimeInAuditoriumPreview() {
    TimeScreenTimeInAuditorium()
}