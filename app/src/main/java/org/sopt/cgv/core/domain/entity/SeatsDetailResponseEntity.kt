package org.sopt.cgv.core.domain.entity

data class SeatsDetailResponseEntity(
    val id: Long,
    val name: String,
    val auditoriumType: String,
    val theaterName: String,
    val startTime: String,
    val endTime: String,
    val releaseDate: String,
    val isMorning: Boolean,
    val seatIOS: String,
    val seatAnd: String
)
