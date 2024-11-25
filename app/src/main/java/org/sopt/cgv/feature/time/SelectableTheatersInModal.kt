package org.sopt.cgv.feature.time

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.R
import org.sopt.cgv.core.common.extension.noRippleClickable
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray200
import org.sopt.cgv.core.designsystem.theme.Gray700
import org.sopt.cgv.core.designsystem.theme.Gray850
import org.sopt.cgv.core.designsystem.theme.PrimaryRed400
import org.sopt.cgv.core.designsystem.theme.White


data class MovieTheatersByDetailRegion(
    val detailRegionName: String,
    val theaterNames: PersistentList<String>
)

@Composable
fun SelectableTheatersInModal(
    movieTheatersByDetailRegion: PersistentList<MovieTheatersByDetailRegion>,
    selectedTheaters: MutableState<Set<String>>,
    modifier: Modifier = Modifier
) {
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

        items(movieTheatersByDetailRegion) { movieTheatersByDetailRegion ->
            DetailRegionTheaters(
                detailRegionName = movieTheatersByDetailRegion.detailRegionName,
                theaterNames = movieTheatersByDetailRegion.theaterNames,
                selectedTheaters = selectedTheaters
            )
        }
    }
}

@Composable
fun DetailRegionTheaters(
    detailRegionName: String,
    theaterNames: PersistentList<String>,
    selectedTheaters: MutableState<Set<String>>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxWidth()
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
                selectedTheaters = selectedTheaters
            )
        }

        Spacer(modifier = Modifier.height(36.dp))
    }
}

@Composable
fun TheaterListItem(
    theaterName: String,
    selectedTheaters: MutableState<Set<String>>,
    modifier: Modifier = Modifier
) {
    var isSelected by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .noRippleClickable {
                isSelected = !isSelected
                if (isSelected) selectedTheaters.value = selectedTheaters.value.plus(theaterName)
                else selectedTheaters.value = selectedTheaters.value.minus(theaterName)
            }
            .background(color = if (isSelected) Gray200 else White)
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
                style = if (isSelected) CGVTheme.typography.head4_b_15 else CGVTheme.typography.body3_m_14,
                color = Gray850
            )

            Spacer(modifier = Modifier.weight(1f))

            if (isSelected) {
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
        movieTheatersByDetailRegion = persistentListOf(
            MovieTheatersByDetailRegion(
                detailRegionName = "최근 이용한 CGV",
                theaterNames = persistentListOf("구리", "압구정"),
            ),
            MovieTheatersByDetailRegion(
                detailRegionName = "현재 주변에 있는 CGV",
                theaterNames = persistentListOf("용산아이파크몰"),
            )
        ),
        selectedTheaters = selectedTheaters
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
        selectedTheaters = selectedTheaters
    )
}

@Preview(showBackground = true)
@Composable
private fun TheaterListItemPreview() {
    val selectedTheaters = remember { mutableStateOf(setOf<String>()) }

    TheaterListItem(
        theaterName = "용산아이파크몰",
        selectedTheaters = selectedTheaters,
        modifier = Modifier
    )
}