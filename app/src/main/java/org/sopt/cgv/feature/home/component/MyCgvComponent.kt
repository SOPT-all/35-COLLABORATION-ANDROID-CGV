package org.sopt.cgv.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray100
import org.sopt.cgv.core.designsystem.theme.Gray850
import org.sopt.cgv.core.designsystem.theme.PrimaryRed600

@Composable
fun MyCgvComponent(
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector,
    title: String,
    count: Int
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(color = Gray100)
            .padding(horizontal = 13.dp, vertical = 11.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
                tint = PrimaryRed600,
            )
            Text(
                text = title,
                style = CGVTheme.typography.head2_b_13,
                color = Gray850
            )
        }

        Text(
            text = "${count}편",
            style = CGVTheme.typography.head3_b_14,
            color = Gray850
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyCgvComponentPreview() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        CGVTheme {
            MyCgvComponent(
                leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_home_movie),
                title = "내가 본 영화",
                count = 9
            )
        }

        CGVTheme {
            MyCgvComponent(
                leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_home_like),
                title = "기대되는 영화",
                count = 2
            )
        }

        CGVTheme {
            MyCgvComponent(
                leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_home_pen),
                title = "내가 쓴 리뷰",
                count = 1
            )
        }
    }
}
