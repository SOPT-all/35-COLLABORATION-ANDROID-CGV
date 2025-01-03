package org.sopt.cgv.feature.time.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.component.card.CompTimeCard
import org.sopt.cgv.core.designsystem.theme.Black
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray100
import org.sopt.cgv.core.designsystem.theme.Gray600
import org.sopt.cgv.feature.time.data.Theater
import org.sopt.cgv.feature.time.data.TimeTable

@Composable
fun TimeScreenAuditorioumAndTimeSelection(
    selectedTheaters: Set<String>,
    theaterList: PersistentList<Theater>,
    navigateToSeat: () -> Unit,
    timeTableList: PersistentList<TimeTable>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        selectedTheaters.forEach { theater ->
            val theaterId = theaterList.filter { it.theaterName == theater }[0].id
            TimeScreenAuditoriumAndTimeInTheater(
                theaterName = theater,
                theaterId = theaterId,
                navigateToSeat = navigateToSeat,
                timeTableList = timeTableList.filter { timeTable ->
                    timeTable.id in (theaterId - 1) * 6 + 1..(theaterId - 1) * 6 + 6
                }.toPersistentList()
            )
        }
    }
}

@Composable
fun TimeScreenAuditoriumAndTimeInTheater(
    theaterName: String,
    theaterId: Int,
    navigateToSeat: () -> Unit,
    timeTableList: PersistentList<TimeTable>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Spacer(Modifier.height(26.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_time_subtract),
                contentDescription = "위치",
                tint = Color.Unspecified,
                modifier = Modifier.padding(horizontal = 2.dp)
            )

            Text(
                text = theaterName,
                style = CGVTheme.typography.head6_b_17,
                color = Black
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.padding(horizontal = 18.dp)
        ) {
            TimeScreenTimeInAuditorium(
                timeTableList = timeTableList.filter { timeTable ->
                    timeTable.auditorium == (
                            combinationList.filter { combination ->
                                combination.id == theaterId
                            }[0].auditorium
                            )
                }.toPersistentList(),
                navigateToSeat = navigateToSeat
            )
            TimeScreenTimeInAuditorium(
                timeTableList = timeTableList.filter { timeTable ->
                    timeTable.auditorium == (
                            combinationList.filter { combination ->
                                combination.id == theaterId
                            }[1].auditorium
                            )
                }.toPersistentList(),
                navigateToSeat = navigateToSeat
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .background(color = Gray100)
        )
    }

}

@Composable
fun TimeScreenTimeInAuditorium(
    timeTableList: PersistentList<TimeTable>,
    navigateToSeat: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (timeTableList.isNotEmpty()) {
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = timeTableList[0].auditoriumType,
                    style = CGVTheme.typography.head1_b_12,
                    color = Gray600
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = timeTableList[0].auditorium,
                    style = CGVTheme.typography.body1_m_12,
                    color = Gray600
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(items = timeTableList) { timeTable ->
                    Column(modifier = Modifier.height(70.dp)) {
                        CompTimeCard(
                            startTime = timeTable.startTime.slice(11..15),
                            endTime = timeTable.endTime.slice(11..15),
                            currentSeats = 183,
                            totalSeats = 185,
                            isMorning = timeTable.morning,
                            isActivated = true,
                            isInTime = true
                        ) { navigateToSeat() }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TimeScreenTimeAuditorioumAndTimeSelectionPreview() {
    val selectedTheaters = remember { mutableStateOf(setOf("용산아이파크몰", "구리")) }

    TimeScreenAuditorioumAndTimeSelection(
        selectedTheaters = selectedTheaters.value,
        theaterList = persistentListOf(),
        timeTableList = persistentListOf(),
        navigateToSeat = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun TimeScreenAuditorioumAndTimeInTheaterPreview() {
    TimeScreenAuditoriumAndTimeInTheater(
        theaterName = "용산아이파크몰",
        theaterId = 3,
        timeTableList = persistentListOf(),
        navigateToSeat = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun TimeScreenTimeInAuditoriumPreview() {
    TimeScreenTimeInAuditorium(
        timeTableList = persistentListOf(
            TimeTable(
                auditorium = "7관",
                auditoriumType = "2D",
                id = 1,
                startTime = "07:50",
                endTime = "09:41",
                morning = true,
                movieName = "글래디에이터",
                ticket = persistentListOf(),
                seatAnd = "",
                seatiOS = ""
            )
        ),
        navigateToSeat = {}
    )
}