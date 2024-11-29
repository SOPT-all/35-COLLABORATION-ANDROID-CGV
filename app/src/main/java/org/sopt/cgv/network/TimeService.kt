package org.sopt.cgv.network

import org.sopt.cgv.feature.time.data.TheatersResponse
import org.sopt.cgv.feature.time.data.TimeTableResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TimeService {
    @GET("/theater")
    suspend fun getTheaters(): TheatersResponse

    @GET("/theater/{theaterId}/movie")
    suspend fun getTimeTables(
        @Path("theaterId") theaterId: Int,
        @Query("auditorium") auditorium: String,
        @Query("auditoriumType") auditoriumType: String
    ): TimeTableResponse
}