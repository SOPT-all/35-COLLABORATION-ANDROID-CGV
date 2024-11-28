package org.sopt.cgv.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.theme.Black
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray100
import org.sopt.cgv.core.designsystem.theme.Gray800

@Composable
fun CgvFooter(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Gray100)
            .padding(top = 16.dp, start = 18.dp)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "CJ CGV (주)",
                style = CGVTheme.typography.head0_b_11,
                color = Black
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_arrow_down),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.padding(start = 4.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "이용약관",
                style = CGVTheme.typography.small1_l_10,
                color = Gray800
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_footer_line),
                contentDescription = null,
                tint = Color.Unspecified,
            )

            Text(
                text = "개인정보 처리방침",
                style = CGVTheme.typography.small1_l_10,
                color = Gray800
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_footer_line),
                contentDescription = null,
                tint = Color.Unspecified,
            )

            Text(
                text = "위치기반서비스 이용약관",
                style = CGVTheme.typography.small1_l_10,
                color = Gray800
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_footer_line),
                contentDescription = null,
                tint = Color.Unspecified,
            )

            Text(
                text = "법적고지",
                style = CGVTheme.typography.small1_l_10,
                color = Gray800
            )
        }
        Spacer(modifier = Modifier.padding(36.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun CgvFooterPreview() {
    CGVTheme {
        CgvFooter()
    }
}
