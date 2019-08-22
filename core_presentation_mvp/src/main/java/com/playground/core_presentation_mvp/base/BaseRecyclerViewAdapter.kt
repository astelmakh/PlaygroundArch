package com.playground.core_presentation_mvp.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T, VH : RecyclerView.ViewHolder>(var data: MutableList<T> = ArrayList(),
                                          open var onItemClickListener: ((T) -> Unit?)? = null)
    : RecyclerView.Adapter<VH>() {

    override fun onBindViewHolder(holder: VH, position: Int) {

        val adapterPosition = holder.adapterPosition
        if (adapterPosition != RecyclerView.NO_POSITION) {
            val item = data[adapterPosition]
            holder.itemView.setOnClickListener { onItemClickListener?.invoke(item) }
            onBindViewHolder(holder, item, adapterPosition)
        }
    }

    abstract fun onBindViewHolder(holder: VH, item: T, position: Int)

    override fun getItemCount(): Int {
        return data.size
    }

    open fun getItem(position: Int): T {
        return data[position]
    }

    open fun replaceAll(list: List<T>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }
}