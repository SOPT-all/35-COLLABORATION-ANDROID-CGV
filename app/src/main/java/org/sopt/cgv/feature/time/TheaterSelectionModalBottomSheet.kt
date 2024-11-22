package org.sopt.cgv.feature.time

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.core.designsystem.theme.White

@ExperimentalMaterial3Api
@Composable
fun TheaterSelectionModalBottomSheet(
    isSheetOpen: Boolean,
    onDismissRequest: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    if (isSheetOpen) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            modifier = Modifier
                .height(650.dp),
            dragHandle = null
        ) {
            val selectedIndex = remember { mutableStateOf(0) }
            val tabs = persistentListOf("지역별", "특별관")
            val regions = persistentListOf(
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
            val movieTheatersByDetailRegion = persistentListOf(
                MovieTheatersByDetailRegion(
                    theaterNames = persistentListOf("구리", "압구정"),
                    detailRegionName = "최근 이용한 CGV"
                ),
                MovieTheatersByDetailRegion(
                    theaterNames = persistentListOf("용산아이파크몰"),
                    detailRegionName = "현재 주변에 있는 CGV"
                )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(White)
            ) {
                Spacer(modifier = Modifier.height(10.dp))

                TheaterClassificationTabInModal(selectedIndex, tabs)

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.weight(1f)
                ) {
                    ClickableVerticalRegionListInModal(
                        list = regions
                    )

                    Spacer(modifier = Modifier.width(33.dp))

                    SelectableTheatersInModal(
                        modifier = Modifier.weight(1f),
                        movieTheatersByDetailRegion = movieTheatersByDetailRegion
                    )
                }

                TheaterSelectionModalFooter(
                    sheetState = sheetState,
                    onDismissRequest = onDismissRequest
                )
            }
        }
    }
}