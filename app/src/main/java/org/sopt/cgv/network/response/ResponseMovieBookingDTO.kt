package org.sopt.cgv.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseMovieBookingFailedDTO(
    @SerialName("status")
    val status: Int,
    @SerialName("success")
    val success: Boolean? = null,
    @SerialName("message")
    val message: String
)

@Serializable
data class ResponseMovieBookingDTO(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String
)