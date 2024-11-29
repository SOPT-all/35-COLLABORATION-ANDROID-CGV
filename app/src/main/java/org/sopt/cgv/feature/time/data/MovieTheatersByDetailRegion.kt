package org.sopt.cgv.feature.time.data

import kotlinx.collections.immutable.PersistentList

data class MovieTheatersByDetailRegion(
    val detailRegionName: String,
    val theaterNames: PersistentList<String>
)
