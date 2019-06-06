package com.rain.apptest.adapter

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

private val TAG: String = "SimpleAdapter"

class SimpleAdapter(val c: Context, var data: List<String>) : RecyclerView.Adapter<SimpleAdapter.MyViewHolder>() {


    private var l: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = View.inflate(c, android.R.layout.simple_list_item_1, null)

        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            l?.onItemClick(holder.itemView, position)
        }
        holder.t.text = data[position]
    }


    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val t: TextView by lazy {
            (v.findViewById(android.R.id.text1)) as TextView
        }
    }

    interface OnItemClickListener {
        fun onItemClick(v: View, position: Int)
    }

    fun setOnItemClickListener(l: OnItemClickListener) {
        this.l = l
    }
}