package org.sopt.cgv.feature.time

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeScreen(
    modifier: Modifier = Modifier
){
    var isSheetOpen by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Button(
            onClick = {isSheetOpen = !isSheetOpen}
        ) { }
    }

    TheaterSelectionModalBottomSheet(
        isSheetOpen = isSheetOpen,
        onDismissRequest = {isSheetOpen = false}
    )
}

@ExperimentalMaterial3Api
@Composable
fun TheaterSelectionModalBottomSheet(
    isSheetOpen: Boolean,
    onDismissRequest: () -> Unit
){
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val coroutineScope = rememberCoroutineScope()

    if (isSheetOpen) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            modifier = Modifier
                .height(650.dp),
            dragHandle = null
        ) {
            val selectedIndex = remember { mutableStateOf(0) }
            val tabs = listOf("지역별","특별관")

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(horizontal = 18.dp)
            ) {
                TheaterClassificationTab(selectedIndex, tabs)
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        coroutineScope.launch {
                            sheetState.hide()
                            onDismissRequest()
                        }
                    }
                ) {
                    Text("극장 선택")
                }
            }
        }
    }
}

@Composable
private fun TheaterClassificationTab(
    selectedIndex: MutableState<Int>,
    tabs: List<String>
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(
            selectedTabIndex = selectedIndex.value,
            modifier = Modifier,
            containerColor = Color.White,
            contentColor = Color.White,
            indicator = { tabPositions ->
                TabRowDefaults.PrimaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedIndex.value]),
                    width = 155.dp,
                    color = Color.Red
                )
            },
            divider = {}
        ) {
            tabs.forEachIndexed { index, category ->
                Tab(
                    selected = selectedIndex.value == index,
                    onClick = { selectedIndex.value = index },
                    modifier = Modifier.padding(vertical = 10.dp),
                    selectedContentColor = Color.Red,
                    unselectedContentColor = Color.Black
                ) {
                    Text(text = category)
                }
            }
        }
    }
}

@Preview
@Composable
fun TimeScreenPreview(){
    TimeScreen()
}