package org.sopt.cgv.feature.seats

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.core.designsystem.component.card.CompTimeCard
import java.time.LocalDateTime

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
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        contentPadding = PaddingValues(horizontal = 10.dp)
    ) {
        items(contents) { eachCard ->
            CompTimeCard(
                startTime = eachCard.startTime,
                endTime = eachCard.endTime,
                currentSeats = eachCard.currentSeats,
                totalSeats = eachCard.totalSeats,
                isMorning = eachCard.isMorning
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SeatSelectionTimeCardRowPreview(){
    val sampleTimeCardData = persistentListOf(
        TimeCardContent(
            startTime = LocalDateTime.of(2024, 11, 19, 7, 50),
            endTime = LocalDateTime.of(2024, 11, 19, 9, 41),
            currentSeats = 185,
            totalSeats = 178,
            isMorning = true,
        ),
        TimeCardContent(
            startTime = LocalDateTime.of(2024, 11, 19, 7, 50),
            endTime = LocalDateTime.of(2024, 11, 19, 9, 41),
            currentSeats = 185,
            totalSeats = 178,
            isMorning = true,
        ),
        TimeCardContent(
            startTime = LocalDateTime.of(2024, 11, 19, 7, 50),
            endTime = LocalDateTime.of(2024, 11, 19, 9, 41),
            currentSeats = 185,
            totalSeats = 178,
            isMorning = true,
        )
    )
    SeatSelectionTimeCardRow(contents = sampleTimeCardData)
}