package dev.pstens.usecases

import dev.pstens.data.StatsRepository
import dev.pstens.domain.Stat

class GetStats(private val repo: StatsRepository) {
    suspend operator fun invoke(refresh: Boolean = false): List<Stat> {
        val stats = repo.getStats(refresh)
        return stats.sortedByDescending { (it.total + (it.live ?: 0)) }
    }
}