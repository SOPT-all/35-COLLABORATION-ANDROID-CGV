package org.sopt.cgv.feature.seats

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    val isMorning: Boolean,
    val isActivated: Boolean
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SeatSelectionTimeCardRow(
    contents: PersistentList<TimeCardContent>,
    modifier: Modifier = Modifier,
) {
    var clickedCardIndex = remember { mutableStateOf(Int) }

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        contentPadding = PaddingValues(horizontal = 10.dp)
    ) {
        itemsIndexed(contents) { index: Int, eachCard ->
            CompTimeCard(
                modifier = Modifier,
                startTime = eachCard.startTime,
                endTime = eachCard.endTime,
                currentSeats = eachCard.currentSeats,
                totalSeats = eachCard.totalSeats,
                isMorning = eachCard.isMorning,
                isActivated = eachCard.isActivated,
                onClick = {}
            )
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun SeatSelectionTimeCardRowPreview() {
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
        )
    )
    SeatSelectionTimeCardRow(contents = sampleTimeCardData)
}