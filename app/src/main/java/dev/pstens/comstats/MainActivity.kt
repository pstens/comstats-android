package dev.pstens.comstats

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import dev.pstens.comstats.databinding.ActivityMainBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<StatsViewModel>()
    private val itemAdapter = ItemAdapter<StatItem>()
    private val fastAdapter = FastAdapter.with(itemAdapter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.content.adapter = fastAdapter
        viewModel.stats.observe(this, Observer<List<StatItem>> { items ->
            itemAdapter.set(items)
        })
        binding.refresh.setOnClickListener {
            viewModel.loadStats(refresh = false)
        }
        binding.refreshServer.setOnClickListener {
            viewModel.loadStats(refresh = true)
        }
    }

    private fun textView(text: String) = TextView(this).apply {
        textSize = 16f
        setTextColor(Color.WHITE)
        setText(text)
        setPadding(16, 8, 16, 8)
    }
}
