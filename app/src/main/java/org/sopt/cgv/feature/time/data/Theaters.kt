package org.sopt.cgv.feature.time.data

import kotlinx.serialization.Serializable

@Serializable
data class TheatersResponse(
    val status: Int,
    val message: String,
    val data: List<Theater>
)

@Serializable
data class Theater(
    val id: Int,
    val theaterName: String
)
