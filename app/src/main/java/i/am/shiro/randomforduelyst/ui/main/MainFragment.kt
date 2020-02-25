package i.am.shiro.randomforduelyst.ui.main

import android.os.Bundle
import android.view.View
import androidx.core.view.children
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import i.am.shiro.randomforduelyst.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment(R.layout.main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        for (i in 0 until 9 * 5) {
            layoutInflater.inflate(R.layout.tile, grid, false)
                .also { grid.addView(it) }
                .setOnClickListener { tile ->
                    tile.isActivated = !tile.isActivated
                    if (tile.isSelected) tile.isSelected = false
                }
        }

        select_all_button.setOnClickListener {
            grid.forEach { tile -> tile.isActivated = true }
        }

        deselect_all_button.setOnClickListener {
            grid.forEach { tile -> tile.isActivated = false }
        }

        clear_button.setOnClickListener {
            grid.forEach { tile -> tile.isSelected = false }
        }

        roll_button.setOnClickListener {
            grid.children
                .filter { it.isActivated && !it.isSelected }
                .toList()
                .takeIf { it.isNotEmpty() }
                ?.random()
                ?.isSelected = true
        }
    }
}
