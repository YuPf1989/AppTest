package com.rain.apptest.data

import com.rain.apptest.R
import com.rain.apptest.data.bean.ItemBean
import com.rain.apptest.data.bean.MySection
import com.rain.apptest.data.bean.SectionBean

object DataUtil {

    private var sData: ArrayList<String>? = null
    private var sectionData: ArrayList<SectionBean>? = null
    private var tabNames: ArrayList<MySection>? = null
    private var sectionData2: ArrayList<MySection>? = null


    fun getStringData(): ArrayList<String> {
        if (sData == null) {
            sData = ArrayList()
            for (i in 0..20) {
                sData!!.add("第 $i 个条目")
            }
        }
        return sData!!
    }

    /**
     * 二维数据结构
     */
    fun getSectionData(): ArrayList<SectionBean> {
        if (sectionData == null) {
            sectionData = ArrayList()
            for (i in 0..8) {
                val items = ArrayList<ItemBean>()
                for (j in 0..7) {
                    items.add(ItemBean(R.mipmap.ic_launcher_round, "item$j"))
                }
                sectionData!!.add(SectionBean("区块$i", items))
            }
        }
        return sectionData!!
    }

    /**
     * 一维数据结构
     */
    fun getSectionData2():ArrayList<MySection>{
        if (sectionData2 == null) {
            sectionData2 = ArrayList()
            val sectionData = getSectionData()
            var subItemPos = 0
            sectionData.forEach {
                sectionData2!!.add(MySection(header = it.title, isHeader = true, subItemPos = subItemPos))
                it.data.forEach {
                    sectionData2!!.add(MySection(it))
                }
                subItemPos += it.data.size + 1 // 转化成一维列表时的position
            }
        }
        return sectionData2!!
    }

    fun getTabNames(): ArrayList<MySection> {
        if (tabNames == null) {
            tabNames = ArrayList()
            val sectionData = getSectionData()
            var subItemPos = 0
            sectionData.forEach {
                tabNames!!.add(MySection(header = it.title, isHeader = true, subItemPos = subItemPos))
                subItemPos += it.data.size + 1 // 转化成一维列表时的position
            }
        }
        return tabNames!!
    }
}