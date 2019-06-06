package com.rain.apptest.adapter

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.rain.apptest.R
import com.rain.apptest.data.bean.ItemBean
import com.rain.apptest.data.bean.SectionBean
import com.rain.apptest.widget.DividerGridItemDecoration

class SectionAdapter(data: List<SectionBean>) :
    BaseQuickAdapter<SectionBean, BaseViewHolder>(R.layout.item_section, data) {
    private var itemClickListener: OnItemClickListener? = null


    override fun convert(helper: BaseViewHolder, item: SectionBean) {
        helper.run {
            setText(R.id.title, item.title)
            val recyclerView = getView<RecyclerView>(R.id.recycler)
            val mItemAdapter = ItemAdapter(item.data)
            recyclerView.run {
                layoutManager = GridLayoutManager(mContext, 4)
                itemClickListener.let {
                    mItemAdapter.onItemClickListener = it
                }
                // 有固定item数量时能提高性能
                setHasFixedSize(true)
                isNestedScrollingEnabled = false
                adapter = mItemAdapter
                addItemDecoration(DividerGridItemDecoration(mContext))
            }
        }
    }

    fun setItemClickListener(l:OnItemClickListener){
        this.itemClickListener = l
    }
}

class ItemAdapter(data: List<ItemBean>) : BaseQuickAdapter<ItemBean, BaseViewHolder>(R.layout.item_section_item, data) {
    override fun convert(helper: BaseViewHolder, item: ItemBean) {
        helper.run {
            setText(R.id.tv_item_name, item.name)
            setImageResource(R.id.icon, item.icon_url)
        }
    }
}