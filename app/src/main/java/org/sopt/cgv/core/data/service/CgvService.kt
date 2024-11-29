package org.sopt.cgv.core.data.service

import org.sopt.cgv.core.common.network.BaseResponse
import org.sopt.cgv.core.data.dto.response.SeatsDetailResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CgvService {
    @GET("/movie/{movieId}")
    suspend fun getSeatsDetail(
        @Path("movieId") movieId: Long
    ): BaseResponse<List<SeatsDetailResponseDto>>
}
