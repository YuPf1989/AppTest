package com.rain.apptest.ui.recycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rain.apptest.R

/**
 * 嵌套
 */
class NestedFragment: androidx.fragment.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // 参数：布局id，指定父布局协助生成布局参数，是否加载进父布局
        return inflater.inflate(R.layout.fragment_recycler,null)
    }

    companion object{
        fun getInstance()  = NestedFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }



}