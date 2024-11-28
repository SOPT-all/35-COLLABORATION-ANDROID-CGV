package org.sopt.cgv.feature.time.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.R
import org.sopt.cgv.core.common.extension.noRippleClickable
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray200
import org.sopt.cgv.core.designsystem.theme.Gray700
import org.sopt.cgv.core.designsystem.theme.Gray850
import org.sopt.cgv.core.designsystem.theme.PrimaryRed400
import org.sopt.cgv.core.designsystem.theme.White
import org.sopt.cgv.feature.time.data.Theater

@Composable
fun SelectableTheatersInModal(
    selectedTheaters: Set<String>,
    onTheaterSelected: (String) -> Unit,
    theaterList: List<Theater>,
    getTheaters: () -> Unit,
    modifier: Modifier = Modifier
) {

    LaunchedEffect(Unit) {
        getTheaters()
    }

    LazyColumn(
        modifier = modifier
            .padding(end = 18.dp)
    ) {
        item { Spacer(modifier = Modifier.height(26.dp)) }

        item {
            Text(
                text = stringResource(R.string.cgv_theater_selection_guide),
                style = CGVTheme.typography.small1_l_10,
                color = Gray700
            )
        }

        item { Spacer(modifier = Modifier.height(25.dp)) }

        item {
            DetailRegionTheaters(
                detailRegionName = "최근 이용한 CGV",
                theaterNames = if (theaterList.isNotEmpty()) listOf(
                    theaterList[0].theaterName,
                    theaterList[1].theaterName
                ) else listOf(),
                selectedTheaters = selectedTheaters,
                onTheaterSelected = onTheaterSelected
            )
        }

        item {
            DetailRegionTheaters(
                detailRegionName = "현재 주변에 있는 CGV",
                theaterNames = if (theaterList.isNotEmpty()) listOf(theaterList[2].theaterName) else listOf(),
                selectedTheaters = selectedTheaters,
                onTheaterSelected = onTheaterSelected
            )
        }
    }
}

@Composable
fun DetailRegionTheaters(
    detailRegionName: String,
    theaterNames: List<String>,
    selectedTheaters: Set<String>,
    onTheaterSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = detailRegionName,
            style = CGVTheme.typography.head0_b_10,
            color = PrimaryRed400
        )

        Spacer(modifier = Modifier.height(25.dp))

        theaterNames.forEach {
            TheaterListItem(
                theaterName = it,
                selectedTheaters = selectedTheaters,
                onTheaterSelected = onTheaterSelected
            )
        }

        Spacer(modifier = Modifier.height(36.dp))
    }
}

@Composable
fun TheaterListItem(
    theaterName: String,
    selectedTheaters: Set<String>,
    onTheaterSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp)
            .noRippleClickable {
                onTheaterSelected(theaterName)
            }
            .background(color = if (selectedTheaters.contains(theaterName)) Gray200 else White)
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                val y = size.height - strokeWidth / 2
                drawLine(
                    color = Gray200,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
            }
            .padding(horizontal = 8.dp, vertical = 11.dp)
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = theaterName,
                style = if (selectedTheaters.contains(theaterName)) CGVTheme.typography.head4_b_15 else CGVTheme.typography.body3_m_14,
                color = Gray850
            )

            Spacer(modifier = Modifier.weight(1f))

            if (selectedTheaters.contains(theaterName)) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_time_modal_check),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(horizontal = 5.dp, vertical = 7.dp),
                    tint = PrimaryRed400
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SelectableTheatersInModalPreview() {
    val selectedTheaters = remember { mutableStateOf(setOf<String>()) }

    SelectableTheatersInModal(
        selectedTheaters = selectedTheaters.value,
        onTheaterSelected = {
            if (selectedTheaters.value.contains(it)) selectedTheaters.value -= it
            else selectedTheaters.value -= it
        },
        theaterList = listOf(
            Theater(id = 1, theaterName = "구리"),
            Theater(id = 2, theaterName = "압구정"),
            Theater(id = 3, theaterName = "용산아이파크몰"),
        ),
        getTheaters = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun DetailRegionTheatersPreview() {
    val selectedTheaters = remember { mutableStateOf(setOf<String>()) }

    DetailRegionTheaters(
        detailRegionName = "최근 이용한 CGV",
        theaterNames = persistentListOf("구리", "압구정"),
        modifier = Modifier,
        selectedTheaters = selectedTheaters.value,
        onTheaterSelected = {
            if (selectedTheaters.value.contains(it)) selectedTheaters.value -= it
            else selectedTheaters.value -= it
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun TheaterListItemPreview() {
    val selectedTheaters = remember { mutableStateOf(setOf<String>()) }

    TheaterListItem(
        theaterName = "용산아이파크몰",
        selectedTheaters = selectedTheaters.value,
        onTheaterSelected = {
            if (selectedTheaters.value.contains(it)) selectedTheaters.value -= it
            else selectedTheaters.value += it
        }
    )
}