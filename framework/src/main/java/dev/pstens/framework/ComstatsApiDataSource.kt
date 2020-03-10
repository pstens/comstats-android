package dev.pstens.framework

import dev.pstens.data.RemoteDataSource
import dev.pstens.domain.Stat

class ComstatsApiDataSource : RemoteDataSource {
    private val api by lazy { ComstatsApi.create() }

    override suspend fun fetch(): List<Stat> {
        val response = api.fetchCurrentScore()
        return if (response.isSuccessful) {
            response.body()?.score ?: emptyList()
        } else {
            emptyList()
        }
    }
}