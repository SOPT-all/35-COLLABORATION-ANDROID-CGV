package org.sopt.cgv.feature.time

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.cgv.core.designsystem.theme.Gradient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeScreen(
    modifier: Modifier = Modifier
) {
    var isSheetOpen by remember { mutableStateOf(true) }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .background(Gradient)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 18.dp)
                .padding(top = 19.dp)
        ) {
            TimeScreenTobBar()


            Button(
                onClick = { isSheetOpen = !isSheetOpen }
            ) { }
        }
    }

    TheaterSelectionModalBottomSheet(
        isSheetOpen = isSheetOpen,
        onDismissRequest = { isSheetOpen = false }
    )
}

@Preview
@Composable
fun TimeScreenPreview() {
    TimeScreen()
}