package com.example.ahndwon.fragmentrecyclerviewexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_basic.view.*
import kotlinx.android.synthetic.main.item_top.view.*

class ItemListAdapter(private val type: Int = 0) : RecyclerView.Adapter<ItemViewHolder>() {
    var items : List<String> = emptyList()

    companion object {
        const val VIEW_TOP = 0
        const val VIEW_BASIC = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return when (type) {
            VIEW_TOP -> {
                val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_top, parent, false )
                ItemViewHolder(view)
            }

            else -> {
                val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_basic, parent, false )
                ItemViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        with(holder.itemView) {
            when (type) {
                VIEW_TOP -> {
                    GlideApp.with(this.context).load(item)
                            .centerCrop()
                            .into(this.topImageView)
                }
                VIEW_BASIC -> {
                    GlideApp.with(this.context).load(item)
                            .centerCrop()
                            .into(this.basicImageView)
                }

                else -> {

                }
            }
        }

    }

}