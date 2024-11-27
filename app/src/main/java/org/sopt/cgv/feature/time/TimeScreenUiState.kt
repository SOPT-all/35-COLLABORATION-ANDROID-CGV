package org.sopt.cgv.feature.time

import androidx.annotation.DrawableRes
import org.sopt.cgv.R

data class TimeScreenUiState(
    val selectedTabInModalIndex: Int = 0,
    val selectedRegionInModal: String = "추천 CGV",
    val selectedTheaters: Set<String> = setOf(),
    val selectedTimeScreenTobBarTabIndex: Int = 0,
    @DrawableRes val selectedPoster: Int = R.drawable.img_time_poster1_selected,
    val selectedDate: String = "11.28",
    val selectedDay: String = "목",
    val isSheetOpen: Boolean = true
)