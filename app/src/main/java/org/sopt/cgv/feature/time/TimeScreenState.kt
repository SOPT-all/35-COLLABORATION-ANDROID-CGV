package org.sopt.cgv.feature.time

import androidx.annotation.DrawableRes
import org.sopt.cgv.R
import org.sopt.cgv.feature.time.data.Theater

data class TimeScreenState(
    val tobBarTabIndex: Int = 0,
    @DrawableRes val poster: Int = R.drawable.img_time_poster1_selected,
    val date: String = "11.28",
    val day: String = "목",
)

data class TimeModalState(
    val tabIndex: Int = 0,
    val region: String = "추천 CGV",
    val theaters: Set<String> = setOf(),
    val isSheetOpen: Boolean = true,
    val theaterList: List<Theater> = listOf()
)