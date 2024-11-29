package org.sopt.cgv.feature.time.data

import kotlinx.collections.immutable.PersistentList
import kotlinx.serialization.Serializable

@Serializable
data class TimeTableResponse(
    val status: Int,
    val message: String,
    val data: MovieList
)

@Serializable
data class MovieList(
    val movieList: List<TimeTable>
)

@Serializable
data class TimeTable(
    val id: Int,
    val ticket: List<String>,
    val auditorium: String,
    val auditoriumType: String,
    val startTime: String,
    val endTime: String,
    val morning: Boolean,
    val movieName: String,
    val seatiOS: String,
    val seatAnd: String
)

