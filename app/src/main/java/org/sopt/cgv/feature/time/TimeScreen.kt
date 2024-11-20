package org.sopt.cgv.feature.time

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.core.designsystem.theme.CGVTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeScreen(
    modifier: Modifier = Modifier
) {
    var isSheetOpen by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = { isSheetOpen = !isSheetOpen }
        ) { }
    }

    TheaterSelectionModalBottomSheet(
        isSheetOpen = isSheetOpen,
        onDismissRequest = { isSheetOpen = false }
    )
}

@Composable
fun TheaterClassificationTabInModal(
    selectedIndex: MutableState<Int>,
    tabs: List<String>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp)
    ) {
        TabRow(
            selectedTabIndex = selectedIndex.value,
            modifier = Modifier,
            containerColor = Color.White,
            contentColor = Color.White,
            indicator = { tabPositions ->
                TabRowDefaults.PrimaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedIndex.value]),
                    width = 175.dp,
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
                    Text(
                        text = category,
                        style = CGVTheme.typography.body3_m_14
                    )
                }
            }
        }
    }
}

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

@Preview
@Composable
fun TimeScreenPreview() {
    TimeScreen()
}