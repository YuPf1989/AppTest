package com.rain.apptest.data.bean

import androidx.annotation.DrawableRes
import com.chad.library.adapter.base.entity.SectionEntity
import com.rain.apptest.R

data class SectionBean(
    val title: String,
    val data: List<ItemBean>
)

data class ItemBean(
    @DrawableRes
    val icon_url: Int = R.mipmap.ic_launcher_round,
    val name: String
)

/**
 * section Header
 */
class MySection : SectionEntity<ItemBean> {
    var subItemPos = 0

    constructor(isHeader: Boolean = false, header: String, subItemPos: Int) : super(isHeader, header) {
        this.subItemPos = subItemPos
    }

    constructor(t: ItemBean) : super(t)
}



