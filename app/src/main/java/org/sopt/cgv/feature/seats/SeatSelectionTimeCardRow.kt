package org.sopt.cgv.feature.seats

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.core.designsystem.component.card.CompTimeCard
import java.time.LocalDateTime

//modifier: Modifier = Modifier,
//startTime: LocalDateTime,
//endTime: LocalDateTime,
//currentSeats: Int,
//totalSeats: Int,
//isMorning: Boolean

data class TimeCardContent(
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val currentSeats: Int,
    val totalSeats: Int,
    val isMorning: Boolean
)


@Composable
fun SeatSelectionTimeCardRow(
    contents: PersistentList<TimeCardContent>,
    modifier: Modifier = Modifier,
){
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 20.dp)
    ) {
        items(contents) { eachCard ->
            CompTimeCard(
                modifier = modifier,
                startTime = eachCard.startTime
            )

        }
    }

}

//modifier: Modifier = Modifier,
//startTime: LocalDateTime,
//endTime: LocalDateTime,
//currentSeats: Int,
//totalSeats: Int,
//isMorning: Boolean

@Preview(showBackground = true)
@Composable
fun SeatSelectionTimeCardRowPreview(){
    SeatSelectionTimeCardRow()
}