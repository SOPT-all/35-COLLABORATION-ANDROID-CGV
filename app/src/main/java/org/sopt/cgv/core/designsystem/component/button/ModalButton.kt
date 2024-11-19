package org.sopt.cgv.core.designsystem.component.button

import android.R
import android.widget.Button
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.cgv.core.designsystem.theme.Gray200
import org.sopt.cgv.core.designsystem.theme.PrimaryRed400
import org.sopt.cgv.core.designsystem.theme.White

data class ButtonStyle(
    val backgroundColor: Color,
    val border: BorderStroke?,
    val textColor: Color,
)

@Composable
fun getButtonStyle(buttonType: String): ButtonStyle {
    return remember(buttonType) {
        when (buttonType) {
            "Choice" -> ButtonStyle(
                backgroundColor = PrimaryRed400,
                border = null,
                textColor = White
            )
            "Back" -> ButtonStyle(
                backgroundColor = White,
                border = BorderStroke(1.dp, PrimaryRed400),
                textColor = PrimaryRed400
            )
            else -> ButtonStyle(
                backgroundColor = PrimaryRed400,
                border = null,
                textColor = White
            )
        }
    }

}

@Composable
fun ModalButton(
    buttonType: String,   //선택 버튼인 경우 Choice, 뒤로가기인 경우 Back
    initialActivation: Boolean, // 처음부터 활성화 상태면 true, 활성화 조건 필요하면 false
    content: String,
    length: String,     //long, half로 사용
){

    var isActivated by remember { mutableStateOf(initialActivation) }
    val buttonStyle = getButtonStyle(buttonType)

    val (buttonWidth, buttonHeight) = remember(length) {
        when (length) {
            "long" -> Pair(324.dp, 54.dp)
            "half" -> Pair(156.dp, 54.dp)
            else -> Pair(324.dp, 54.dp)
        }
    }

    Box(
        modifier = Modifier
            .size(width = buttonWidth, height = buttonHeight)
            .clip(RoundedCornerShape(12.dp))
            .background(buttonStyle.backgroundColor)
            .then(
                if (buttonStyle.border != null)
                    Modifier.border(buttonStyle.border, RoundedCornerShape(8.dp))
                else
                    Modifier
            )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Text(
                text = content,
                color = buttonStyle.textColor
            )

        }
    }
}



@Preview
@Composable
fun ButtonPreview(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ModalButton(
            buttonType = "Choice",
            initialActivation = true,
            content = "좌석선택",
            length = "long"
        )
        ModalButton(
            buttonType = "Back",
            initialActivation = false,
            content = "뒤로가기",
            length = "half"
        )
        ModalButton(
            buttonType = "Choice",
            initialActivation = true,
            content = "확인",
            length = "half"
        )
    }
}