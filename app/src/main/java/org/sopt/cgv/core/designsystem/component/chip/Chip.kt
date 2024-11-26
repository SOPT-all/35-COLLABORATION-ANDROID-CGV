package org.sopt.cgv.core.designsystem.component.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.theme.Black
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray100
import org.sopt.cgv.core.designsystem.theme.Gray300
import org.sopt.cgv.core.designsystem.theme.Gray700
import org.sopt.cgv.core.designsystem.theme.Gray850

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    content: String,
    inTime: Boolean = false,
    onTheaterSelected: ((String) -> Unit)? = null
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(if (inTime) Gray300 else Gray100)
            .padding(
                if (inTime) PaddingValues(start = 12.dp, end = 6.dp, top = 8.dp, bottom = 8.dp)
                else PaddingValues(vertical = 6.dp, horizontal = 8.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = content,
            color = if (inTime) Gray850 else Gray700,
            style = CGVTheme.typography.head3_b_14
        )
        if (inTime) {
            Spacer(Modifier.width(4.dp))

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_x),
                contentDescription = "닫기",
                tint = Black,
                modifier = Modifier
                    .size(16.dp)
                    .clickable {
                        if (onTheaterSelected != null) onTheaterSelected(content)
                    }
            )
        }
    }
}

@Preview
@Composable
fun SeatChoiceModalChipPreview() {
    Chip(
        modifier = Modifier,
        content = "2024.11.9 (토)"
    )
}

@Preview
@Composable
fun SeatChoiceModalChipPreview2() {
    val selectedTheaters = remember { mutableStateOf(setOf<String>()) }

    Chip(
        modifier = Modifier,
        content = "용산",
        inTime = true,
        onTheaterSelected = {
            if (selectedTheaters.value.contains(it)) selectedTheaters.value -= it
            else selectedTheaters.value += it
        }
    )
}