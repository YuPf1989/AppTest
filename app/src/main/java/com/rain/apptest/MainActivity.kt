package com.rain.apptest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rain.apptest.ui.ToolbarActivity
import com.rain.apptest.ui.ToolbarActivity2
import com.rain.apptest.ui.WebViewActivity
import com.rain.apptest.ui.recycler.RecyclerTestActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 主要是各种功能的测试
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_recycler.setOnClickListener {
            startActivity(Intent(this,RecyclerTestActivity::class.java))
        }

        btn_webview.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }

        btn_toolbar.setOnClickListener {
            startActivity(Intent(this, ToolbarActivity::class.java))
        }

        btn_toolbar2.setOnClickListener {
            startActivity(Intent(this, ToolbarActivity2::class.java))
        }
    }
}


