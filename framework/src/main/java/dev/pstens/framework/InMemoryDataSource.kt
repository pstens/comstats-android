package dev.pstens.framework

import dev.pstens.data.LocalDateSource
import dev.pstens.domain.Stat

class InMemoryDataSource : LocalDateSource {
    private val cachedStats = mutableSetOf<Stat>()

    override suspend fun getAll(): List<Stat> = cachedStats.toList()

    override suspend fun add(vararg stats: Stat) {
        cachedStats += stats
    }

}