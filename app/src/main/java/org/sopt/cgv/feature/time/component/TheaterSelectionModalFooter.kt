package org.sopt.cgv.feature.time.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.launch
import org.sopt.cgv.core.common.extension.dropShadow
import org.sopt.cgv.core.designsystem.component.button.CgvButton
import org.sopt.cgv.core.designsystem.component.chip.Chip
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.White
import org.sopt.cgv.feature.time.data.Theater

data class Combination(
    val id: Int,
    val auditorium: String,
    val auditoriumType: String
)

val combinationList: PersistentList<Combination> = persistentListOf(
    Combination(1, "1관", "2D"),
    Combination(1, "2관", "2D"),
    Combination(2, "1관", "IMAX"),
    Combination(2, "2관", "2D"),
    Combination(3, "1관", "IMAX"),
    Combination(3, "2관", "2D"),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TheaterSelectionModalFooter(
    sheetState: SheetState,
    onDismissRequest: () -> Unit,
    getTimeTables: (Int, String, String) -> Unit,
    theaterList: List<Theater>,
    selectedTheaters: Set<String>,
    onTheaterSelected: (String) -> Unit,
    initTimeTableList: () -> Unit,
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = modifier
            .dropShadow(
                shape = RectangleShape,
                color = Color(0x1A000000),
                blur = 10.dp,
                offsetY = (-4).dp,
                offsetX = 0.dp,
                spread = 0.dp
            )
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = White)
                .padding(horizontal = 18.dp)
        ) {
            ShowSelectedChipsBox(
                selectedTheaters = selectedTheaters,
                onTheaterSelected = onTheaterSelected
            )

            CgvButton(
                modifier = Modifier.fillMaxWidth(),
                text = "극장선택",
                textStyle = CGVTheme.typography.head6_b_17,
                verticalPadding = 16.dp,
                roundedCornerShape = 10.dp,
                onClick = {
                    coroutineScope.launch {
                        sheetState.hide()
                        onDismissRequest()
                        selectedTheaters.forEach { selectedTheater ->
                            val id = theaterList.filter { it.theaterName == selectedTheater }[0].id
                            for (i in 0..1) {
                                getTimeTables(
                                    id,
                                    combinationList[(id - 1) * 2 + i].auditorium,
                                    combinationList[(id - 1) * 2 + i].auditoriumType
                                )
                            }
                        }
                    }
                }
            )

            Spacer(modifier = Modifier.height(38.dp))
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ShowSelectedChipsBox(
    selectedTheaters: Set<String>,
    onTheaterSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier.padding(vertical = 14.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        selectedTheaters.forEach { theaterName ->
            Chip(
                content = theaterName,
                inTime = true,
                onTheaterSelected = onTheaterSelected
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun TheaterSelectionModalFooterPreview() {
    val selectedTheaters = remember { mutableStateOf(setOf("구리", "압구정")) }
    TheaterSelectionModalFooter(
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
        onDismissRequest = {},
        selectedTheaters = selectedTheaters.value,
        onTheaterSelected = {
            if (selectedTheaters.value.contains(it)) selectedTheaters.value -= it
            else selectedTheaters.value += it
        },
        getTimeTables = {a,b,c ->},
        theaterList = listOf(),
        initTimeTableList = {}
    )
}

@Preview
@Composable
private fun ShowSelectedChipsBoxPreview() {
    val selectedTheaters = remember { mutableStateOf(setOf("구리", "압구정")) }
    ShowSelectedChipsBox(
        modifier = Modifier,
        selectedTheaters = selectedTheaters.value,
        onTheaterSelected = {
            if(selectedTheaters.value.contains(it)) selectedTheaters.value -= it
            else selectedTheaters.value += it
        }
    )
}
