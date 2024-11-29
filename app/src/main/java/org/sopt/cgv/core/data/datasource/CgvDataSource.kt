package org.sopt.cgv.core.data.datasource

import org.sopt.cgv.core.common.network.BaseResponse
import org.sopt.cgv.core.data.dto.response.SeatsDetailResponseDto

interface CgvDataSource {
    suspend fun getSeatsDetail(
        movieId: Long
    ): BaseResponse<List<SeatsDetailResponseDto>>
}
