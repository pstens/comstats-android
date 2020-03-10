package dev.pstens.framework

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ComstatsApi {

    @GET("stats")
    suspend fun fetchCurrentScore(): Response<ScoreResponse>

    companion object {
        fun create(): ComstatsApi = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://comstats-api.pstens.now.sh/")
            .build()
            .create()
    }
}
