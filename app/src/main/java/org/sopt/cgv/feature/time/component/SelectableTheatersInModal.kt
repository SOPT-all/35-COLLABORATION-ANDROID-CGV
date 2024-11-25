package org.sopt.cgv.feature.time.component

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray200
import org.sopt.cgv.core.designsystem.theme.Gray700
import org.sopt.cgv.core.designsystem.theme.Gray850
import org.sopt.cgv.core.designsystem.theme.PrimaryRed400
import org.sopt.cgv.core.designsystem.theme.White


data class MovieTheatersByDetailRegion(
    val detailRegionName: String,
    val theaterNames: List<String>
)

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
                style = CGVTheme.typography.small1_l_10,
                color = Gray700
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
            color = PrimaryRed400
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
            .height(44.dp)
            .clickable { isSelected = !isSelected }
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
                    painter = painterResource(R.drawable.ic_time_modal_check),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(horizontal = 5.dp, vertical = 7.dp),
                    tint = PrimaryRed400
                )
            }
        }
    }
}