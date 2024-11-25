package org.sopt.cgv.feature.seats.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.R
import org.sopt.cgv.core.common.extension.noRippleClickable
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.core.designsystem.theme.Gray100
import org.sopt.cgv.core.designsystem.theme.Gray700
import org.sopt.cgv.core.designsystem.theme.Gray800
import org.sopt.cgv.core.designsystem.theme.White

@Composable
fun Stepper(
    modifier: Modifier = Modifier,
    initialValue: Int = 0,
    onValueChange: (Int) -> Unit
) {
    var currentValue by remember { mutableStateOf(initialValue) }

    Row(
        modifier = modifier
            .size(height = 36.dp, width = 100.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Gray100),
    ) {
        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
        ){
            // - 버튼
            Box(
                modifier = Modifier
                    .noRippleClickable {
                        if (currentValue > 0) {
                            currentValue--
                            onValueChange(currentValue)
                        }
                    }
                    .size(20.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_seats_minus),
                    contentDescription = "인원 감소",
                    tint = Gray800,
                    modifier = Modifier.size(20.dp)
                )
            }

            // 현재 값
            Box(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .size(width = 34.dp, height = 28.dp)
                    .background(White, RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = currentValue.toString(),
                    style = CGVTheme.typography.head6_b_17,
                    color = Gray700
                )
            }

            // + 버튼
            Box(
                modifier = Modifier
                    .noRippleClickable {
                        currentValue++
                        onValueChange(currentValue)
                    }
                    .size(20.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_seats_plus),
                    contentDescription = "인원 증가",
                    tint = Gray800,
                    modifier = Modifier.size(20.dp) // 아이콘 크기
                )
            }
        }

    }
}

@Preview
@Composable
fun StepperPreview() {
    Stepper(
        modifier = Modifier,
        initialValue = 0,
        onValueChange = { newValue ->
            println("Stepper value changed: $newValue")
        }
    )
}