package com.rain.apptest.ui

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_web.*


class WebViewActivity : AppCompatActivity() {

    private val urll = "http://i.tianqi.com/index.php?c=code&id=10&color=%23C6C6C6&icon=1&py=zhengzhou&site=12"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.rain.apptest.R.layout.activity_web)

        webview.run {
            loadUrl(urll)

//            webViewClient = object : WebViewClient() {
//                @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
//                override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
//                    Log.e("rrrr",request?.url.toString())
//                    view?.loadUrl(url)
//                    return true
//                }
//            }

            webViewClient = object :WebViewClient(){
                override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                    webview.loadUrl(url)
                    return true
                }
            }

            settings.javaScriptEnabled = true

        }

        btn_back.setOnClickListener {
            if (webview.canGoBack()) {
                webview.goBack()
            }
        }

        btn_forward.setOnClickListener {
            if (webview.canGoForward()) {
                webview.goForward()
            }
        }
    }
}