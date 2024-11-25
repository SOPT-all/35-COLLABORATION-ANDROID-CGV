package org.sopt.cgv.feature.time

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.core.common.extension.noRippleClickable
import org.sopt.cgv.core.designsystem.theme.Black
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray700

@Composable
fun ClickableVerticalRegionListInModal(
    list: PersistentList<String>,
    selectedRegionInModal: MutableState<String>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(start = 29.dp),
        contentPadding = PaddingValues(vertical = 12.dp)
    ) {
        items(
            items = list,
            key = { it }
        ) { item ->
            Box(
                modifier = Modifier
                    .width(139.dp)
                    .height(46.dp)
                    .noRippleClickable { selectedRegionInModal.value = item }
            ) {
                Text(
                    text = item,
                    modifier = Modifier.align(Alignment.CenterStart),
                    style = if (selectedRegionInModal.value == item) CGVTheme.typography.head3_b_14 else CGVTheme.typography.body3_m_14,
                    color = if (selectedRegionInModal.value == item) Black else Gray700
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ClickableVerticalRegionListInModalPreview() {
    val selectedRegionInModal = remember { mutableStateOf("추천 CGV") }

    ClickableVerticalRegionListInModal(
        list = persistentListOf(
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
        ),
        selectedRegionInModal = selectedRegionInModal
    )
}