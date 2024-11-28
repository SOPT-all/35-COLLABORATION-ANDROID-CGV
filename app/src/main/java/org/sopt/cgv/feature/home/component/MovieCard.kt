package org.sopt.cgv.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.component.button.CgvButton
import org.sopt.cgv.core.designsystem.theme.Black
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray800
import org.sopt.cgv.core.designsystem.theme.PrimaryRed400

@Composable
fun MovieCard(
    movieImageRes: Int,
    movieTitle: String,
    likePercentage: String,
    rating: String,
    ageRatingIcon: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Column(
        modifier = modifier.width(160.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = movieImageRes),
            contentDescription = null,
            modifier = Modifier
                .width(160.dp)
                .height(230.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = movieTitle,
                style = CGVTheme.typography.head3_b_14,
                color = Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.padding(2.dp))
            Icon(
                imageVector = ImageVector.vectorResource(id = ageRatingIcon),
                contentDescription = "Age Rating",
                tint = Color.Unspecified,
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_99),
                contentDescription = "Age Rating",
                modifier = Modifier.size(18.dp)
            )

            Text(
                text = "$likePercentage%",
                style = CGVTheme.typography.head2_b_13,
                color = Gray800
            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_divider),
                contentDescription = "divider",
                tint = Color.Unspecified,
            )

            Text(
                text = rating,
                style = CGVTheme.typography.head2_b_13,
                color = PrimaryRed400
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        CgvButton(
            text = "지금예매",
            horizontalPadding = 54.dp,
            verticalPadding = 8.dp,
            textStyle = CGVTheme.typography.head3_b_14,
            onClick = onClick
        )

    }
}

@Preview
@Composable
private fun MovieCardPreview() {
    MovieCard(
        movieImageRes = R.drawable.img_movie1,
        movieTitle = "청설",
        likePercentage = "99.9",
        rating = "D-1",
        ageRatingIcon = R.drawable.ic_all,
        onClick = {}
    )
}
