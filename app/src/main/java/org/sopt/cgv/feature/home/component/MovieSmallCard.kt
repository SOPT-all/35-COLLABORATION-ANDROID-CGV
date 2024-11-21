package org.sopt.cgv.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray100
import org.sopt.cgv.core.designsystem.theme.Gray700
import org.sopt.cgv.core.designsystem.theme.Gray800

@Composable
fun MovieSmallCard(
    movieImage: Int,
    title: String,
    percentage: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(58.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(Gray100),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = movieImage),
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp))
                .width(41.dp)
                .height(58.dp),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                style = CGVTheme.typography.head2_b_13,
                color = Gray800
            )

            Text(
                text = "예매율 $percentage",
                style = CGVTheme.typography.body0_m_11,
                color = Gray700
            )
        }

        ReservationButton(
            text = "예매",
            horizontalPadding = 4.dp,
            verticalPadding = 2.dp,
            textStyle = CGVTheme.typography.body1_m_12
        )

        Spacer(modifier = Modifier.width(8.dp))
    }
}

@Preview
@Composable
fun PreviewMovieDetailItem() {
    MovieSmallCard(
        movieImage = R.drawable.img_special1,
        title = "글래디에이터 II",
        percentage = "17.3%",
    )
}

@Preview
@Composable
fun PreviewMovieDetailItem2() {
    MovieSmallCard(
        movieImage = R.drawable.img_special2,
        title = "글래디에이터 II",
        percentage = "17.3%",
    )
}
