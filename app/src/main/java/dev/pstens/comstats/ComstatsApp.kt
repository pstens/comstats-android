package dev.pstens.comstats

import android.app.Application
import dev.pstens.data.StatsRepository
import dev.pstens.framework.ComstatsApiDataSource
import dev.pstens.framework.InMemoryDataSource
import dev.pstens.usecases.GetStats
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class ComstatsApp : Application() {
    private val modules = module {
        single { StatsRepository(InMemoryDataSource(), ComstatsApiDataSource()) }
        viewModel { StatsViewModel(GetStats(get())) }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            modules(modules)
        }
    }
}
