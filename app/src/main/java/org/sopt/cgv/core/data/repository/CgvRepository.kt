package org.sopt.cgv.core.data.repository

import org.sopt.cgv.core.domain.entity.SeatsDetailResponseEntity

interface CgvRepository {
    suspend fun getSeatsDetail(
        movieId: Long
    ): Result<List<SeatsDetailResponseEntity>>
}