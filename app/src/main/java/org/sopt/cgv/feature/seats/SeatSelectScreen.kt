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
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import org.sopt.cgv.core.designsystem.theme.Gray900
import org.sopt.cgv.feature.seats.component.SeatConfirmationModal
import org.sopt.cgv.feature.seats.component.SeatSelectionModal1
import org.sopt.cgv.feature.seats.component.SeatsScreenTopBar
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import org.sopt.cgv.R
import org.sopt.cgv.core.data.repository.CgvRepository

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SeatSelectScreen(
    modifier: Modifier = Modifier,
    movieId: Long,
    repository: CgvRepository,
    onNavigateBack: () -> Unit = {},
) {
    val viewModel: SeatSelectViewModel = viewModel(
        factory = SeatSelectViewModelFactory(repository)
    )

    LaunchedEffect(Unit) {
        viewModel.fetchMovieDetails(movieId)
    }

    val movieTitle = viewModel.movieTitle
    val chipContents = viewModel.chipContents

    val scrollState = rememberScrollState()

    val selectionBottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val confirmationBottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val focusManager = LocalFocusManager.current

    val showBottomSheet = viewModel.showBottomSheet
    val isSeatSelected = viewModel.isSeatSelected
    val showSeatConfirmBottomSheet = viewModel.showSeatConfirmBottomSheet

    val stepperValues = viewModel.stepperValues

    val sampleTimeCardData = viewModel.timeCardData


    Scaffold(
        modifier = modifier,
    ) { innerPadding ->

        if (showBottomSheet) {
            LaunchedEffect(showBottomSheet) { selectionBottomSheetState.expand() }
            SeatSelectionModal1(
                modifier = Modifier,
                stepperValues = stepperValues,
                onStepperIncrease = { index -> viewModel.increaseStepperValue(index) },
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
        ) {
            SeatsScreenTopBar(
                modifier = Modifier,
                clickedTimeCardIndex = viewModel.clickedTimeCardIndex.value,
                onTimeCardClick = { index ->
                    viewModel.updateClickedTimeCardIndex(index)
                    viewModel.updateSelectedSeatUrl(index)
                    viewModel.toggleBottomSheet()
                },
                timeCardContent = sampleTimeCardData,
                onBackClick = onNavigateBack
            )



            if (isSeatSelected) {
                Image(
                    painter = painterResource(id = R.drawable.img_seats1_selected),
                    contentDescription = "좌석표",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            viewModel.toggleSeat()
                            viewModel.toggleSeatConfirmBottomSheet()
                        },
                    contentScale = ContentScale.Crop
                )
            } else {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(viewModel.selectedSeatUrl)
                        .crossfade(true)
                        .build(),
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
}
