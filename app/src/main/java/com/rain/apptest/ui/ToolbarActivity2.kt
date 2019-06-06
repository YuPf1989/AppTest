package com.rain.apptest.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rain.apptest.R
import com.rain.apptest.adapter.BaseAdapter
import com.rain.apptest.data.DataUtil
import kotlinx.android.synthetic.main.activity_toolbar2.*

/**
 * 沉浸式状态栏+toolbar变色实现二
 */
class ToolbarActivity2 : AppCompatActivity() {

    private val mAdapter by lazy {
        BaseAdapter(DataUtil.getStringData())
    }

    private val manager by lazy {
        LinearLayoutManager(this@ToolbarActivity2)
    }

    private var header_hight: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar2)

        //透明状态栏
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)


        val header = layoutInflater.inflate(R.layout.item_header, null)
        header.run {
            mAdapter.addHeaderView(header)
            post {
                header_hight = this.height / 2
            }
        }

        recycler.run {
            layoutManager = manager
            adapter = mAdapter
            addOnScrollListener(scrollListener)
        }


    }

    private var scrollY = 0

    private val scrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            scrollY += dy
            if (scrollY <= 0) {
//                toolbar.setBackgroundResource(android.R.color.transparent)
//                tv_title.setText("")
            } else if (scrollY > 0 && scrollY < header_hight) {
                val fraction = scrollY * 1f / header_hight
                toolbar.setBackgroundColor(changeAlpha(resources.getColor(R.color.colorPrimary), fraction))
                tv_title.setTextColor(changeAlpha(resources.getColor(android.R.color.white), fraction))
            } else if (scrollY >= header_hight) {
                toolbar.setBackgroundResource(R.color.colorPrimary)
                tv_title.setText("List")
            }
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