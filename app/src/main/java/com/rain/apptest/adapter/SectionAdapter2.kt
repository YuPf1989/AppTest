package com.rain.apptest.adapter

import com.chad.library.adapter.base.BaseSectionQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.rain.apptest.R
import com.rain.apptest.data.bean.MySection

class SectionAdapter2(data: List<MySection>) :
    BaseSectionQuickAdapter<MySection, BaseViewHolder>(R.layout.item_section_item,R.layout.item_section_header, data) {
    override fun convertHead(helper: BaseViewHolder?, item: MySection?) {
        helper ?: return
        item ?: return
        helper.run {
            setText(R.id.tv_item_name, item.header)
        }
    }

    override fun convert(helper: BaseViewHolder, item: MySection) {
        val bean = item.t
        helper.run {
            setText(R.id.tv_item_name, bean.name)
            setImageResource(R.id.icon,R.mipmap.ic_launcher_round)
        }
    }
}

