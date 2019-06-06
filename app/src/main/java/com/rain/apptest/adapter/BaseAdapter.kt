package com.rain.apptest.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class BaseAdapter(data:List<String>):BaseQuickAdapter<String,BaseViewHolder>(android.R.layout.simple_list_item_1,data) {
    override fun convert(helper: BaseViewHolder?, item: String?) {
        helper?:return
        item?:return
        helper.setText(android.R.id.text1,item)
    }
}