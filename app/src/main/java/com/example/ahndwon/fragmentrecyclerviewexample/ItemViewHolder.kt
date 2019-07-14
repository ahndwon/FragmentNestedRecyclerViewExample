package com.example.ahndwon.fragmentrecyclerviewexample

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_basic.view.*

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: String) {
        Glide.with(itemView.context).load(item)
            .centerCrop()
            .into(itemView.basicImageView)
    }
}