package org.sopt.cgv.core.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.sopt.cgv.core.domain.entity.SeatsDetailResponseEntity

@Serializable
data class SeatsDetailResponseDto(
    @SerialName("movieId")
    val movieId: Long,
    @SerialName("movieName")
    val movieName: String,
    @SerialName("auditoriumType")
    val auditoriumType: String,
    @SerialName("theaterName")
    val theaterName: String,
    @SerialName("startTime")
    val startTime: String,
    @SerialName("endTime")
    val endTime: String,
    @SerialName("releaseDate")
    val releaseDate: String,
    @SerialName("isMorning")
    val isMorning: Boolean,
    @SerialName("seatiOS")
    val seatIOS: String,
    @SerialName("seatAnd")
    val seatAnd: String
) {
    fun SeatsDetailResponseEntity() = SeatsDetailResponseEntity(
        id = movieId,
        name = movieName,
        auditoriumType = auditoriumType,
        theaterName = theaterName,
        startTime = startTime,
        endTime = endTime,
        releaseDate = releaseDate,
        isMorning = isMorning,
        seatIOS = seatIOS,
        seatAnd = seatAnd
    )
}
