package org.sopt.cgv.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.R
import org.sopt.cgv.core.common.extension.noRippleClickable
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.White

@Composable
fun CgvTopBar(
    modifier: Modifier = Modifier,
    onTicketClick: () -> Unit = {},
    onSearchClick: () -> Unit = {},
    onMenuClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(White)
            .padding(top = 10.dp)
            .height(48.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_ticket),
            contentDescription = "Ticket",
            tint = Color.Unspecified,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 13.dp)
                .noRippleClickable(onClick = onTicketClick)
        )

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_logo),
            contentDescription = "CGV Logo",
            tint = Color.Unspecified,
            modifier = Modifier
                .align(Alignment.Center)
        )

        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 9.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_search),
                contentDescription = "Search",
                tint = Color.Unspecified,
                modifier = Modifier.noRippleClickable(onClick = onSearchClick)
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_menu),
                contentDescription = "Menu",
                tint = Color.Unspecified,
                modifier = Modifier.noRippleClickable(onClick = onMenuClick)
            )
        }
    }
}

@Preview
@Composable
fun CgvTopBarDevicePreview() {
    CGVTheme {
        CgvTopBar()
    }
}
