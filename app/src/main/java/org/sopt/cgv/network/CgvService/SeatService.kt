package org.sopt.cgv.network.CgvService

import org.sopt.cgv.network.request.RequestMovieBookingDTO
import org.sopt.cgv.network.response.ResponseMovieBookingDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface SeatService {
    @POST("/movie/booking/{movieId}")
    suspend fun bookMovie(
        @Path("movieId") movieId: Long,
        @Body requestDto: RequestMovieBookingDTO
    ): Response<ResponseMovieBookingDTO>
}
