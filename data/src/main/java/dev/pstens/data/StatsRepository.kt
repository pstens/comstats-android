package dev.pstens.data

import dev.pstens.domain.Stat

class StatsRepository(
    private val localDataSource: LocalDateSource,
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun getStats(refresh: Boolean = false): List<Stat> {
        println("Fetching stats with refresh: $refresh")
        if (refresh) {
            val fromServer = remoteDataSource.fetch()
            localDataSource.add(*fromServer.toTypedArray())
        }
        return localDataSource.getAll()
    }

    suspend fun saveStats(vararg stats: Stat) = localDataSource.add(*stats)
}

interface LocalDateSource {
    suspend fun getAll(): List<Stat>
    suspend fun add(vararg stats: Stat)
}

interface RemoteDataSource {
    suspend fun fetch(): List<Stat>
}