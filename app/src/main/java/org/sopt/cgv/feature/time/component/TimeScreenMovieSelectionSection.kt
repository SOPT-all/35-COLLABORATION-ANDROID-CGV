package org.sopt.cgv.feature.time.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.R
import org.sopt.cgv.core.common.extension.noRippleClickable
import org.sopt.cgv.core.designsystem.theme.Black
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gradient
import org.sopt.cgv.core.designsystem.theme.Gray100
import org.sopt.cgv.core.designsystem.theme.PrimaryRed400
import org.sopt.cgv.core.designsystem.theme.White

@Composable
fun TimeScreenMovieSelectionSection(
    @DrawableRes selectedPoster: Int,
    onPosterSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val posters = persistentListOf(
        R.drawable.img_time_poster1_selected,
        R.drawable.img_time_poster2_selected,
        R.drawable.img_time_poster3_selected,
        R.drawable.img_time_poster4_selected,
        R.drawable.img_time_poster5_selected,
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(138.dp)
                .background(brush = Gradient)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
        ) {
            Spacer(modifier = Modifier.height(19.dp))

            SelectedMovieInformation()

            Spacer(modifier = Modifier.height(19.dp))

            SelectableMoviePosters(
                posters = posters,
                selectedPoster = selectedPoster,
                onPosterSelected = onPosterSelected
            )
        }
    }
}

@Composable
fun SelectableMoviePosters(
    posters: PersistentList<Int>,
    @DrawableRes selectedPoster: Int,
    onPosterSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = posters,
            key = { it }
        ) { poster ->
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .background(color = Black, shape = RoundedCornerShape(5.dp))
                    .noRippleClickable { onPosterSelected(poster) },
            ) {
                Image(
                    painter = painterResource(id = poster),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(5.dp))
                        .fillMaxWidth(0.2f),
                    contentScale = ContentScale.Crop,
                    alpha = if (selectedPoster == poster) 1f else 0.6f
                )
            }
        }
    }
}

@Composable
fun SelectedMovieInformation(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "글래디에이터 ||",
            style = CGVTheme.typography.head6_b_17,
            color = White
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_time_age19_20),
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = Modifier.size(30.dp)
        )

        Text(
            text = "2시간 28분",
            style = CGVTheme.typography.body0_m_11,
            color = White
        )

        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .background(
                    color = Gray100,
                    shape = RoundedCornerShape(6.dp)
                )
                .border(
                    width = 1.dp,
                    color = PrimaryRed400,
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(horizontal = 10.dp)
                .height(24.dp)
        ) {
            Text(
                text = "전체",
                modifier = Modifier.align(Alignment.Center),
                style = CGVTheme.typography.head1_b_12,
                color = PrimaryRed400
            )
        }
    }
}

@Preview
@Composable
private fun TimeScreenMovieSelectionSectionPreview() {
    val selectedPoster = remember { mutableIntStateOf(R.drawable.img_time_poster1_selected) }
    TimeScreenMovieSelectionSection(
        selectedPoster = selectedPoster.intValue,
        onPosterSelected = { selectedPoster.intValue = it }
    )
}

@Preview
@Composable
private fun SelectableMoviePostersPreview() {
    val selectedPoster = remember { mutableIntStateOf(R.drawable.img_time_poster1_selected) }

    SelectableMoviePosters(
        posters = persistentListOf(
            R.drawable.img_time_poster1_selected,
            R.drawable.img_time_poster2_selected,
            R.drawable.img_time_poster3_selected,
            R.drawable.img_time_poster4_selected,
            R.drawable.img_time_poster5_selected,
        ),
        selectedPoster = selectedPoster.intValue,
        onPosterSelected = { selectedPoster.intValue = it }
    )
}

@Preview
@Composable
private fun SelectedMovieInformationPreview() {
    SelectedMovieInformation(
    )
}

