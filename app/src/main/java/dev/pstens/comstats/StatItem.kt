package dev.pstens.comstats

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import dev.pstens.comstats.databinding.ItemStatBinding
import dev.pstens.domain.Stat

class StatItem(
    private val stat: Stat,
    private val position: Int
) : AbstractBindingItem<ItemStatBinding>() {

    override val type: Int
        get() = R.id.fastadapter_item

    override var identifier: Long = stat.hashCode().toLong()

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): ItemStatBinding {
        return ItemStatBinding.inflate(inflater, parent, false)
    }

    @SuppressLint("SetTextI18n")
    override fun bindView(binding: ItemStatBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)
        with(binding) {
            name.text = stat.name
            score.text = "${stat.total + (stat.live ?: 0)} \u2022 (${stat.total} + ${stat.live})"
            rank.text = "$position."
        }
    }
}

fun Stat.toStatItem(position: Int) = StatItem(this, position)