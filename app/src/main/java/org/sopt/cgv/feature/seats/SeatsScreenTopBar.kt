package org.sopt.cgv.feature.seats

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.core.designsystem.theme.Gray800
import org.sopt.cgv.core.designsystem.theme.White
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.theme.Gray700
import org.sopt.cgv.core.designsystem.theme.Typography

@Composable
fun SeatsScreenTopBar(
    modifier: Modifier = Modifier,

){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Gray800)
            .height(300.dp)
    ){
        //TopBar 부분
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Gray700),
        ){
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_back),
                contentDescription = "Go Back",
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(Alignment.CenterVertically)
                    .clickable(){

                    }
            )

            Text(
                text = "[IMAX LASER 2D]",
                modifier = Modifier.align(Alignment.CenterVertically),
                style = Typography.head4_b_15,
                color = Color.White
            )

        }

    }

}


@Preview(showBackground = true)
@Composable
fun SeatsScreenTopBarPreview(){
    SeatsScreenTopBar(
        modifier = Modifier,
    )
}