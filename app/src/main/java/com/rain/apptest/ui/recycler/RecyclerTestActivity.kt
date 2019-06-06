package com.rain.apptest.ui.recycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.rain.apptest.R

class RecyclerTestActivity : AppCompatActivity() {

    private val recyclerFragment: RecyclerFragment by lazy {
        RecyclerFragment.getInstance()
    }

    private val recyclerFragment2: RecyclerFragment2 by lazy {
        RecyclerFragment2.getInstance()
    }

    private val recyclerFragment3 by lazy {
        RecyclerFragment3.getInstance()
    }

    private val nestedFragment by lazy {
        NestedFragment.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_recycler)

        showFragment(recyclerFragment)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.recycler_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            // 复用
            R.id.action_recycle -> {
                showFragment(recyclerFragment)
            }

            // 与NestedScrollView的滑动冲突
            R.id.action_nested1 -> {
                showFragment(nestedFragment)
            }

            R.id.action_section -> {
                showFragment(recyclerFragment2)
            }

            R.id.action_section2 -> {
                showFragment(recyclerFragment3)
            }


        }
        return super.onOptionsItemSelected(item)
    }

    fun showFragment(f: androidx.fragment.app.Fragment) {
        val t = supportFragmentManager.beginTransaction()
        t.replace(R.id.container, f)
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            .commitAllowingStateLoss()
    }
}