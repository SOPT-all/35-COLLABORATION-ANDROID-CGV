package org.sopt.cgv.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.sopt.cgv.BuildConfig
import org.sopt.cgv.core.data.service.CgvService
import org.sopt.cgv.BuildConfig.BASE_URL
import org.sopt.cgv.network.CgvService.SeatService
import org.sopt.cgv.network.request.LocalDateTimeSerializer
import retrofit2.Retrofit

val json = Json {
    serializersModule = SerializersModule {
        contextual(LocalDateTimeSerializer) // LocalDateTimeSerializer 등록
    }
    ignoreUnknownKeys = true
    prettyPrint = true
}

object ApiFactory {
    private const val BASE_URL: String = BuildConfig.BASE_URL

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    inline fun <reified T> create(): T = retrofit.create(T::class.java)
}

object ServicePool {
    val cgvService = ApiFactory.create<CgvService>()
    val seatService = ApiFactory.create<SeatService>()
}
