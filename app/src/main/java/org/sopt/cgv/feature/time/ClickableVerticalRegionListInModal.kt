package org.sopt.cgv.feature.time

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.sopt.cgv.core.designsystem.theme.CGVTheme

@Composable
fun ClickableVerticalRegionListInModal(
    list: List<String>,
    modifier: Modifier = Modifier
) {
    var selectedItem by remember { mutableStateOf<String?>("추천 CGV") }

    LazyColumn(
        modifier = modifier,
    ) {
        items(
            items = list,
            key = { it }
        ) { item ->
            Box(
                modifier = Modifier
                    .width(139.dp)
                    .height(46.dp)
                    .padding(start = 29.dp, top = 12.dp, bottom = 12.dp)
                    .clickable { selectedItem = item }
            ) {
                Text(
                    text = item,
                    style = CGVTheme.typography.body3_m_14,
                    color = if (selectedItem == item) Color.Black else Color.DarkGray
                )
            }
        }
    }
}