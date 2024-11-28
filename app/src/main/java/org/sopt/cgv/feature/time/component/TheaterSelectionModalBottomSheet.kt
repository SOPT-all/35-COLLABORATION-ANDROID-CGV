package org.sopt.cgv.feature.time.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.core.designsystem.theme.White
import org.sopt.cgv.feature.time.data.Theater

@ExperimentalMaterial3Api
@Composable
fun TheaterSelectionModalBottomSheet(
    isSheetOpen: Boolean,
    onDismissRequest: () -> Unit,
    sheetState: SheetState,
    selectedTabInModalIndex: Int,
    onCGVTabInModalSelected: (Int) -> Unit,
    selectedRegionInModal: String,
    onRegionInModalSelected: (String) -> Unit,
    selectedTheaters: Set<String>,
    onTheaterSelected: (String) -> Unit,
    theaterList: List<Theater>,
    getTheaters: () -> Unit,
    getTimeTables: (Int, String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    if (isSheetOpen) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            modifier = modifier
                .height(650.dp),
            dragHandle = null
        ) {
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

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(White)
            ) {
                Spacer(modifier = Modifier.height(10.dp))

                TheaterClassificationTabInModal(
                    selectedTabInModalIndex = selectedTabInModalIndex,
                    onCGVTabInModalSelected = onCGVTabInModalSelected,
                    tabs = tabs
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.weight(1f)
                ) {
                    ClickableVerticalRegionListInModal(
                        list = regions,
                        selectedRegionInModal = selectedRegionInModal,
                        onRegionInModalSelected = onRegionInModalSelected
                    )

                    Spacer(modifier = Modifier.width(33.dp))

                    SelectableTheatersInModal(
                        selectedTheaters = selectedTheaters,
                        onTheaterSelected = onTheaterSelected,
                        modifier = Modifier.weight(1f),
                        theaterList = theaterList,
                        getTheaters = getTheaters
                    )
                }

                TheaterSelectionModalFooter(
                    sheetState = sheetState,
                    onDismissRequest = onDismissRequest,
                    selectedTheaters = selectedTheaters,
                    onTheaterSelected = onTheaterSelected,
                    getTimeTables = getTimeTables,
                    theaterList = theaterList
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun TheaterSelectionModalBottomSheetPreview() {
    val isSheetOpen = remember { mutableStateOf(true) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val selectedTabInModalIndex = remember { mutableIntStateOf(0) }
    val selectedRegionInModal = remember { mutableStateOf("추천 CGV") }
    val selectedTheaters = remember { mutableStateOf(setOf<String>()) }

    TheaterSelectionModalBottomSheet(
        isSheetOpen = isSheetOpen.value,
        onDismissRequest = { isSheetOpen.value = false },
        sheetState = sheetState,
        selectedTabInModalIndex = selectedTabInModalIndex.intValue,
        onCGVTabInModalSelected = { selectedTabInModalIndex.intValue = it },
        selectedRegionInModal = selectedRegionInModal.value,
        onRegionInModalSelected = { selectedRegionInModal.value = it },
        selectedTheaters = selectedTheaters.value,
        onTheaterSelected = {
            if (selectedTheaters.value.contains(it)) selectedTheaters.value -= it
            else selectedTheaters.value -= it
        },
        theaterList = listOf(),
        getTheaters = {},
        getTimeTables = { a, b, c -> }
    )
}

