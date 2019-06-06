package com.rain.apptest.ui.recycler

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.google.android.material.tabs.TabLayout
import com.rain.apptest.R
import com.rain.apptest.adapter.SectionAdapter
import com.rain.apptest.adapter.SectionAdapter2
import com.rain.apptest.data.DataUtil
import kotlinx.android.synthetic.main.fragment_section.*

/**
 * section
 * 不采用RecyclerView嵌套RecyclerView方式
 * 单一RecyclerView
 */
class RecyclerFragment3 : Fragment() {

    /**
     * tab 的position和RecyclerView的Header的position的映射
     */
    private var posMap: MutableMap<Int, Int> = HashMap()

    private val divider by lazy {
        DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
    }

    private val mAdapter by lazy {
        SectionAdapter2(DataUtil.getSectionData2())
    }

    private val mmanager by lazy {
        GridLayoutManager(activity, 4)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // 参数：布局id，指定父布局协助生成布局参数，是否加载进父布局
        return inflater.inflate(R.layout.fragment_section, null)
    }

    companion object {
        fun getInstance() = RecyclerFragment3()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DataUtil.getTabNames().forEachIndexed { index, it ->
            tab.addTab(tab.newTab().setText(it.header).setTag(it.subItemPos))
            posMap.put(it.subItemPos,index)
        }

        tab.addOnTabSelectedListener(tabSelectedListener)

        recycler.run {
            layoutManager = mmanager
            adapter = mAdapter
            mAdapter.onItemClickListener = listener
            addItemDecoration(divider)
            addOnScrollListener(scrollListener)
        }
    }

    private val listener = object : BaseQuickAdapter.OnItemClickListener {
        override fun onItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
            Toast.makeText(activity, "pos:${position}", Toast.LENGTH_SHORT).show()
        }
    }

    private val scrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            val pos = posMap[mmanager.findFirstVisibleItemPosition()]
            if (pos != null) {
                tab.setScrollPosition(pos, 0f, true)
            }
        }
    }

    private val tabSelectedListener = object : TabLayout.OnTabSelectedListener {
        override fun onTabReselected(p0: TabLayout.Tab) {
        }

        override fun onTabUnselected(p0: TabLayout.Tab) {
        }

        override fun onTabSelected(tab: TabLayout.Tab) {
            mmanager.scrollToPositionWithOffset(tab.tag as Int, 0)
        }
    }
}