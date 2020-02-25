package i.am.shiro.randomforduelyst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.forEachIndexed
import androidx.fragment.app.commitNow
import i.am.shiro.randomforduelyst.ui.main.MainFragment
import kotlinx.android.synthetic.main.main_fragment.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.commitNow {
                add(android.R.id.content, MainFragment())
            }
        }
    }
}
