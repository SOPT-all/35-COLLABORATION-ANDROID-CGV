package org.sopt.cgv.feature.seats.component

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.core.designsystem.component.card.CompTimeCard

data class TimeCardContent(
    val startTime: String,
    val endTime: String,
    val currentSeats: Int,
    val totalSeats: Int,
    val isMorning: Boolean,
    val isActivated: Boolean,
    val seatAnd: String
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SeatSelectionTimeCardRow(
    contents: PersistentList<TimeCardContent>,
    selectedIndex: Int,
    onCardClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        contentPadding = PaddingValues(horizontal = 10.dp)
    ) {
        itemsIndexed(contents) { index: Int, eachCard ->
            val isCardActivated = selectedIndex == index

            CompTimeCard(
                modifier = Modifier,
                startTime = eachCard.startTime,
                endTime = eachCard.endTime,
                currentSeats = eachCard.currentSeats,
                totalSeats = eachCard.totalSeats,
                isMorning = eachCard.isMorning,
                isActivated = isCardActivated,
                onClick = {
                    onCardClick(index)
                }
            )
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun SeatSelectionTimeCardRowPreview() {
    val selectedIndex = 0
    val sampleTimeCardData = persistentListOf(
        TimeCardContent(
            startTime = "07:50",
            endTime = "09:51",
            currentSeats = 185,
            totalSeats = 178,
            isMorning = true,
            isActivated = false,
            seatAnd = "https://example.com/seatAnd1"
        ),
        TimeCardContent(
            startTime = "07:50",
            endTime = "09:51",
            currentSeats = 185,
            totalSeats = 178,
            isMorning = true,
            isActivated = false,
            seatAnd = "https://example.com/seatAnd1"
        ),
        TimeCardContent(
            startTime = "07:50",
            endTime = "09:51",
            currentSeats = 185,
            totalSeats = 178,
            isMorning = true,
            isActivated = false,
            seatAnd = "https://example.com/seatAnd1"
        ),
        TimeCardContent(
            startTime = "07:50",
            endTime = "09:51",
            currentSeats = 185,
            totalSeats = 178,
            isMorning = false,
            isActivated = false,
            seatAnd = "https://example.com/seatAnd1"
        )
    )

    Column(
        modifier = Modifier
            .height(70.dp)
            .padding(3.dp)
    ) {
        SeatSelectionTimeCardRow(
            selectedIndex = selectedIndex,
            onCardClick = { },
            contents = sampleTimeCardData
        )
    }
}
