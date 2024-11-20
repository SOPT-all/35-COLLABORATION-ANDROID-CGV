package org.sopt.cgv.feature.time

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.theme.CGVTheme

@Composable
fun SelectableTheatersInModal(
    modifier: Modifier,
    movieTheatersByDetailRegion: List<MovieTheatersByDetailRegion>
) {
    LazyColumn(
        modifier = modifier
            .padding(end = 18.dp)
    ) {
        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            Text(
                text = stringResource(R.string.cgv_theater_selection_guide),
                style = CGVTheme.typography.small1_l_10
            )
        }

        item { Spacer(modifier = Modifier.height(25.dp)) }

        items(movieTheatersByDetailRegion) { movieTheatersByDetailRegion ->
            DetailRegionTheaters(
                theaterNames = movieTheatersByDetailRegion.theaterNames,
                detailRegionName = movieTheatersByDetailRegion.detailRegionName
            )
        }
    }
}

@Composable
fun DetailRegionTheaters(
    theaterNames: List<String>,
    detailRegionName: String
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = detailRegionName,
            style = CGVTheme.typography.head0_b_10,
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(25.dp))
        theaterNames.forEach {
            TheaterListItem(it)
        }
        Spacer(modifier = Modifier.height(36.dp))
    }
}

@Composable
fun TheaterListItem(
    theaterName: String
) {
    var isSelected by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { isSelected = !isSelected }
            .background(color = if (isSelected) Color.Gray else Color.White)
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                val y = size.height - strokeWidth / 2
                drawLine(
                    color = Color(0xFFEDEDED),
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
            }
            .padding(horizontal = 8.dp, vertical = 11.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = theaterName,
                style = CGVTheme.typography.body3_m_14
            )

            Spacer(modifier = Modifier.weight(1f))

            if (isSelected) {
                Icon(
                    painter = painterResource(R.drawable.ic_time_modal_check),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(horizontal = 5.dp, vertical = 7.dp)
                )
            }
        }
    }
}