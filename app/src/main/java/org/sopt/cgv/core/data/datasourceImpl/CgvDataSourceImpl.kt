package org.sopt.cgv.core.data.datasourceImpl

import org.sopt.cgv.core.common.network.BaseResponse
import org.sopt.cgv.core.data.datasource.CgvDataSource
import org.sopt.cgv.core.data.dto.response.SeatsDetailResponseDto
import org.sopt.cgv.core.data.service.CgvService

class CgvDataSourceImpl(
    private val cgvService: CgvService
) : CgvDataSource {
    override suspend fun getSeatsDetail(
        movieId: Long
    ): BaseResponse<List<SeatsDetailResponseDto>> =
        cgvService.getSeatsDetail(movieId)
}