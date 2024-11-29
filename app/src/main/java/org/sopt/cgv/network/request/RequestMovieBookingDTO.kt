package org.sopt.cgv.network.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class RequestMovieBookingDTO(
    @SerialName("movieName")
    val movieName: String,
    @SerialName("theaterName")
    val theaterName: String,
    @Serializable(with = LocalDateTimeSerializer::class)
    @SerialName("startTime")
    val startTime: LocalDateTime,
    @Serializable(with = LocalDateTimeSerializer::class)
    @SerialName("endTime")
    val endTime: LocalDateTime,
    @SerialName("ticketCount")
    val ticketCount: Int
)
