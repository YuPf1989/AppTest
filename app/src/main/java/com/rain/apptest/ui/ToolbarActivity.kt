package com.rain.apptest.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import com.rain.apptest.R
import com.rain.apptest.adapter.SimpleAdapter
import com.rain.apptest.data.DataUtil
import kotlinx.android.synthetic.main.activity_toolbar.*

/**
 * 沉浸式状态栏+toolbar变色
 */
class ToolbarActivity : AppCompatActivity() {
    private val mAdapter by lazy {
        SimpleAdapter(this, DataUtil.getStringData())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)

        //透明状态栏
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, i ->
            val fraction = Math.abs(i * 1.0f) / appBarLayout.totalScrollRange
            val color = changeAlpha(resources.getColor(R.color.colorPrimary), fraction)
            toolbar.setBackgroundColor(color)
        })

        recycler.run {
            layoutManager = LinearLayoutManager(this@ToolbarActivity)
            adapter = mAdapter
            mAdapter.setOnItemClickListener(object : SimpleAdapter.OnItemClickListener {
                override fun onItemClick(v: View, position: Int) {
                    Toast.makeText(this@ToolbarActivity, "pos:${position}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    /**
     * 根据百分比修改颜色透明度
     */
    fun changeAlpha(color: Int, fraction: Float): Int {
        val red = Color.red(color)
        val green = Color.green(color)
        val blue = Color.blue(color)
        val alpha = (Color.alpha(color) * fraction).toInt()
        return Color.argb(alpha, red, green, blue)
    }
}