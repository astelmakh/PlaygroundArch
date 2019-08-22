package com.playground.featureshowcase.presentation.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.playground.featureshowcase.R
import com.playground.core_presentation_mvp.base.BaseRecyclerViewAdapter
import com.playground.featureshowcase.presentation.list.model.ShowCaseItemModel
import javax.inject.Inject

class ShowCaseAdapter
@Inject constructor() : BaseRecyclerViewAdapter<ShowCaseItemModel, ShowCaseAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_showcase, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, item: ShowCaseItemModel, position: Int) {
        Glide.with(holder.itemView.context)
            .load(item.image)
            .into(holder.image)
        holder.title.text = item.title
        holder.description.text = item.subtitle
        holder.btnPurchase.setOnClickListener { onItemClickListener?.invoke(item) }
    }

    class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image: AppCompatImageView = itemView.findViewById(R.id.ivShowCase)
        val title: AppCompatTextView = itemView.findViewById(R.id.tvShowCaseTitle)
        val description: AppCompatTextView = itemView.findViewById(R.id.tvShowCaseDescription)
        val btnPurchase: AppCompatImageButton = itemView.findViewById(R.id.btnPurchase)

    }
}