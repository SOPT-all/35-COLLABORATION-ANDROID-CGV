package org.sopt.cgv.feature.time

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.launch
import org.sopt.cgv.core.designsystem.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TheaterSelectionModalFooter(
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
                .background(color = White)
                .padding(horizontal = 18.dp)
        ) {
            ShowSelectedChipsBox()

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
fun ShowSelectedChipsBox() {
    val chips =
        persistentListOf("Chip 1", "Chip 2", "Chip 3", "Long Chip 4", "Chip 5", "Another Chip 6")

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