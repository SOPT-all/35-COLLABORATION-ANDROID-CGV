package org.sopt.cgv.feature.seats

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.theme.Gray900
import org.sopt.cgv.feature.seats.component.SeatConfirmationModal
import org.sopt.cgv.feature.seats.component.SeatSelectionModal1
import org.sopt.cgv.feature.seats.component.SeatsScreenTopBar
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.collections.immutable.PersistentList


@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SeatSelectScreen(
    modifier: Modifier = Modifier,
    viewModel: SeatSelectViewModel = viewModel(),
    movieTitle: String,
){

    val scrollState = rememberScrollState()

    val selectionBottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val confirmationBottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val focusManager = LocalFocusManager.current

    val showBottomSheet = viewModel.showBottomSheet
    val isSeatSelected = viewModel.isSeatSelected
    val showSeatConfirmBottomSheet = viewModel.showSeatConfirmBottomSheet

    val chipContents = viewModel.chipContents
    val sampleTimeCardData = viewModel.sampleTimeCardData

    val stepperValues = viewModel.stepperValues

    Scaffold(
        modifier = modifier,
    ){  innerPadding ->

        if (showBottomSheet){
            LaunchedEffect(showBottomSheet) { selectionBottomSheetState.expand() }
            SeatSelectionModal1(
                modifier = Modifier,
                stepperValues = stepperValues,
                onStepperIncrease = { index -> viewModel.increaseStepperValue(index) } ,
                onStepperDecrease = { index -> viewModel.decreaseStepperValue(index) },
                movieTitle = movieTitle,
                chipContents = chipContents,
                onDismiss = {
                    viewModel.toggleBottomSheet()
                    focusManager.clearFocus()
                },
                bottomSheetState = selectionBottomSheetState
            )
        }

        if (showSeatConfirmBottomSheet) {
            LaunchedEffect(showSeatConfirmBottomSheet) { confirmationBottomSheetState.expand() }
            SeatConfirmationModal(
                modifier = Modifier,
                movieTitle = movieTitle,
                chipContents = chipContents,
                onDismiss = {
                    viewModel.toggleSeatConfirmBottomSheet()
                    focusManager.clearFocus()
                },
                onBackClick = {
                    viewModel.toggleSeatConfirmBottomSheet()
                },
                onSeatSelectionClick = {
                    viewModel.toggleSeatConfirmBottomSheet()
                },
                bottomSheetState = confirmationBottomSheetState
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(Gray900)
                .padding(innerPadding)
        ){
            SeatsScreenTopBar(
                modifier = Modifier,
                viewModel = viewModel,
                timeCardContent = sampleTimeCardData
            )

            Image(
                painter = painterResource(
                    id = if (isSeatSelected){
                        R.drawable.img_seats1_selected
                    } else {
                        R.drawable.img_seats1_unselected
                    }
                ),
                contentDescription = "좌석표",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        viewModel.toggleSeat()
                        viewModel.toggleSeatConfirmBottomSheet()
                    },
                contentScale = ContentScale.Crop
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun SeatSelectScreenPreview(){
    SeatSelectScreen(
        modifier = Modifier,
        movieTitle = "글래디에이터 2",
    )
}