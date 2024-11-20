package org.sopt.cgv.feature.time

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.sopt.cgv.R
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
fun SelectableTheaters(
    modifier: Modifier,
    movieTheatersByDetailRegion: List<MovieTheatersByDetailRegion>
) {
    LazyColumn(
        modifier = modifier
            .padding(end = 18.dp)
    ) {
        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            Text(
                text = stringResource(R.string.cgv_theater_selection_guide),
                style = CGVTheme.typography.small1_l_10
            )
        }

        item { Spacer(modifier = Modifier.height(25.dp)) }

        items(movieTheatersByDetailRegion) { movieTheatersByDetailRegion ->
            DetailRegionTheaters(
                theaterNames = movieTheatersByDetailRegion.theaterNames,
                detailRegionName = movieTheatersByDetailRegion.detailRegionName
            )
        }
    }
}

data class MovieTheatersByDetailRegion(
    val detailRegionName: String,
    val theaterNames: List<String>
)

@Composable
fun DetailRegionTheaters(
    theaterNames: List<String>,
    detailRegionName: String
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = detailRegionName,
            style = CGVTheme.typography.head0_b_10,
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(25.dp))
        theaterNames.forEach {
            TheaterListItem(it)
        }
        Spacer(modifier = Modifier.height(36.dp))
    }
}

@Composable
fun TheaterListItem(
    theaterName: String
) {
    var isSelected by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { isSelected = !isSelected }
            .background(color = if (isSelected) Color.Gray else Color.White)
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                val y = size.height - strokeWidth / 2
                drawLine(
                    color = Color(0xFFEDEDED),
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
            }
            .padding(horizontal = 8.dp, vertical = 11.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = theaterName,
                style = CGVTheme.typography.body3_m_14
            )

            Spacer(modifier = Modifier.weight(1f))

            if (isSelected) {
                Icon(
                    painter = painterResource(R.drawable.ic_time_modal_check),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(horizontal = 5.dp, vertical = 7.dp)
                )
            }
        }
    }
}


@Composable
fun TheaterClassificationTab(
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
fun ClickableVerticalList(
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TheaterSelectionModalBottom(
    sheetState: SheetState,
    onDismissRequest: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
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
                .background(color = Color.White)
                .padding(horizontal = 18.dp)
        ) {
            SelectedChips()

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

            Spacer(modifier = Modifier.height(38.dp))
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SelectedChips() {
    val chips = listOf("Chip 1", "Chip 2", "Chip 3", "Long Chip 4", "Chip 5", "Another Chip 6")

    FlowRow(
        modifier = Modifier.padding(vertical = 14.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        chips.forEach { chip ->
            Chip(
                text = chip,
                onClick = { }
            )
        }
    }
}

@Composable
fun Chip(text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onClick() }
            .padding(start = 12.dp, end = 6.dp, top = 8.dp, bottom = 8.dp)
    ) {
        Text(
            text = text,
            color = Color.Black
        )
    }
}

fun Modifier.dropShadow(
    shape: Shape,
    color: Color = Color.Black.copy(0.25f),
    blur: Dp = 4.dp,
    offsetY: Dp = 4.dp,
    offsetX: Dp = 0.dp,
    spread: Dp = 0.dp
) = this.drawBehind {
    val shadowSize = Size(size.width + spread.toPx(), size.height + spread.toPx())
    val shadowOutline = shape.createOutline(shadowSize, layoutDirection, this)

    val paint = Paint().apply {
        this.color = color
    }

    if (blur.toPx() > 0) {
        paint.asFrameworkPaint().apply {
            maskFilter = BlurMaskFilter(blur.toPx(), BlurMaskFilter.Blur.NORMAL)
        }
    }

    drawIntoCanvas { canvas ->
        canvas.save()
        canvas.translate(offsetX.toPx(), offsetY.toPx())
        canvas.drawOutline(shadowOutline, paint)
        canvas.restore()
    }
}


@Preview
@Composable
fun TimeScreenPreview() {
    TimeScreen()
}