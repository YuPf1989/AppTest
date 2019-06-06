package com.rain.apptest.ui.recycler

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rain.apptest.R
import com.rain.apptest.adapter.SimpleAdapter
import com.rain.apptest.adapter.SimpleAdapter.*
import com.rain.apptest.data.DataUtil
import kotlinx.android.synthetic.main.fragment_recycler.*

/**
 * 复用
 */
class RecyclerFragment : androidx.fragment.app.Fragment() {
    private val divider by lazy {
        DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
    }

    private val mAdapter by lazy {
        SimpleAdapter(activity!!, DataUtil.getStringData())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // 参数：布局id，指定父布局协助生成布局参数，是否加载进父布局
        return inflater.inflate(R.layout.fragment_recycler, null)
    }

    companion object {
        fun getInstance() = RecyclerFragment()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        divider.setDrawable(resources.getDrawable(R.drawable.divider_shape, null))

        recycler.run {
            layoutManager = LinearLayoutManager(activity)
            adapter = mAdapter
            mAdapter.setOnItemClickListener(object : OnItemClickListener {
                override fun onItemClick(v: View, position: Int) {
                    Toast.makeText(activity, "pos:${position}", Toast.LENGTH_SHORT).show()
                }
            })
            addItemDecoration(divider)
            itemAnimator = DefaultItemAnimator()

        }
    }
}