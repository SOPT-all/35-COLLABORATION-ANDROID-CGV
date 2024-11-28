package org.sopt.cgv.feature.seats.data


data class CGVTimeTable(
    val auditorium: String,
    val auditoriumType: String,
    val movieId: Int,
    val startTime: String,
    val endTime: String,
    val isMorning: Boolean,
    val movieName: String,
    val theaterId: Int
)

