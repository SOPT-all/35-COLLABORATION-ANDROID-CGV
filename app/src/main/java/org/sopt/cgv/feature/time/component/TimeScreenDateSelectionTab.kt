package org.sopt.cgv.feature.time.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.core.designsystem.theme.Black
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray700
import org.sopt.cgv.core.designsystem.theme.PrimaryRed400
import org.sopt.cgv.core.designsystem.theme.White

@Composable
fun TimeScreenDateSelectionTab(
    selectedDate: String,
    onDateSelected: (String) -> Unit,
    selectedDay: String,
    onDaySelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val dateList: PersistentList<Date> = persistentListOf(
        Date("11.28", "목"),
        Date("11.29", "금"),
        Date("11.30", "토"),
        Date("12.1", "일"),
        Date("12.2", "월"),
        Date("12.3", "화"),
        Date("12.4", "수"),
        Date("12.5", "목"),
        Date("12.6", "금"),
        Date("12.7", "토")
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(horizontal = 18.dp)
            .padding(top = 19.dp)
    ) {
        Text(
            text = "2024.${selectedDate} (${selectedDay})",
            style = CGVTheme.typography.body3_m_14,
            color = Black
        )

        Spacer(modifier = Modifier.height(14.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items = dateList) { date ->
                ClickableDate(
                    date = date,
                    selectedDate = selectedDate,
                    onDateSelected = onDateSelected,
                    onDaySelected = onDaySelected,
                    dateList = dateList,
                    modifier = Modifier.fillParentMaxWidth(0.13f),
                )
            }
        }
    }
}

@Composable
fun ClickableDate(
    date: Date,
    selectedDate: String,
    onDateSelected: (String) -> Unit,
    onDaySelected: (String) -> Unit,
    dateList: PersistentList<Date>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .wrapContentHeight()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(shape = RoundedCornerShape(6.dp))
                .clickable {
                    onDateSelected(date.date)
                    onDaySelected(date.day)
                }
                .background(
                    shape = RoundedCornerShape(6.dp),
                    color = if (date.date == selectedDate) PrimaryRed400 else White
                )
        ) {
            Text(
                text = date.date.slice(3 until date.date.length),
                modifier = Modifier.align(Alignment.Center),
                style = CGVTheme.typography.head5_b_16,
                color = if (date.date == selectedDate) White else Black
            )
        }

        Text(
            text = when (dateList.indexOf(date)) {
                0 -> "오늘"
                1 -> "내일"
                else -> date.day
            },
            style = if (date.date == selectedDate) CGVTheme.typography.head1_b_12 else CGVTheme.typography.body1_m_12,
            color = if (date.date == selectedDate) PrimaryRed400 else Gray700
        )
    }
}

@Preview
@Composable
private fun ClickableDatePreview() {
    val selectedDate = remember { mutableStateOf("11.28") }
    val selectedDay = remember { mutableStateOf("목") }
    CGVTheme {
        ClickableDate(
            date = Date("11.28", "목"),
            selectedDate = selectedDate.value,
            onDateSelected = { selectedDate.value = it },
            onDaySelected = { selectedDay.value = it },
            dateList = persistentListOf(
                Date("11.28", "목"),
                Date("11.29", "금"),
                Date("11.30", "토"),
                Date("12.1", "일"),
                Date("12.2", "월"),
                Date("12.3", "화"),
                Date("12.4", "수"),
                Date("12.5", "목"),
                Date("12.6", "금"),
                Date("12.7", "토")
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TimeScreenDateSelectionTabPreview() {
    val selectedDate = remember { mutableStateOf("11.28") }
    val selectedDay = remember { mutableStateOf("목") }
    TimeScreenDateSelectionTab(
        selectedDate = selectedDate.value,
        onDateSelected = { selectedDate.value = it },
        selectedDay = selectedDay.value,
        onDaySelected = { selectedDay.value = it }
    )

}

data class Date(
    val date: String,
    val day: String
)