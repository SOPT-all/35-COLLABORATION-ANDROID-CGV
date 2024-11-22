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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.core.designsystem.theme.Black
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray700

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
                    style = if (selectedItem == item) CGVTheme.typography.head3_b_14 else CGVTheme.typography.body3_m_14,
                    color = if (selectedItem == item) Black else Gray700
                )
            }
        }
    }
}

@Preview
@Composable
private fun ClickableVerticalRegionListInModalPreview(){
    ClickableVerticalRegionListInModal(
        list = listOf(
            "추천 CGV",
            "서울(31)",
            "경기",
            "인천",
            "강원",
            "대전/충청",
            "대구",
            "울산/부산",
            "경상",
            "광주/전라/제주"
        )
    )
}