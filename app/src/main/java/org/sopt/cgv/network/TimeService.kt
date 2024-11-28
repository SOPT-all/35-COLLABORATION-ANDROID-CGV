package org.sopt.cgv.network

import org.sopt.cgv.feature.time.data.TheatersResponse
import retrofit2.http.GET

interface TimeService {
    @GET("/theater")
    suspend fun getTheaters(): TheatersResponse
}