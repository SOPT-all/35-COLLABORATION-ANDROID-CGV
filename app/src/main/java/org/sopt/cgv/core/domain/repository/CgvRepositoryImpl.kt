package org.sopt.cgv.core.domain.repository

import org.sopt.cgv.core.data.datasource.CgvDataSource
import org.sopt.cgv.core.data.repository.CgvRepository
import org.sopt.cgv.core.domain.entity.SeatsDetailResponseEntity

class CgvRepositoryImpl(
    private val cgvDataSource: CgvDataSource
) : CgvRepository {
    override suspend fun getSeatsDetail(movieId: Long): Result<List<SeatsDetailResponseEntity>> =
        runCatching {
            cgvDataSource.getSeatsDetail(movieId).data.map{ it.SeatsDetailResponseEntity()}
        }
}
