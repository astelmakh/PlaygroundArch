package com.playground.featureshowcase.presentation.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.playground.core_presentation.ui.BaseRecyclerViewAdapter
import com.playground.featureshowcase.R
import com.playground.featureshowcase.presentation.model.ShowCaseItemModel
import javax.inject.Inject

class ShowCaseAdapter
@Inject constructor() : BaseRecyclerViewAdapter<ShowCaseItemModel, ShowCaseAdapter.ViewHolder, AppCompatImageView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_showcase, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, item: ShowCaseItemModel, position: Int) {
        Glide.with(holder.itemView.context)
            .load(item.image)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .into(holder.image)
        ViewCompat.setTransitionName(holder.image, "${holder.itemView.context.getString(R.string.transition__showcase_list_to_details)}_$position")
        holder.title.text = item.title
        holder.description.text = item.subtitle
    }

    override fun getSharedElement(holder: ViewHolder): AppCompatImageView? = holder.image

    class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image: AppCompatImageView = itemView.findViewById(R.id.ivShowCase)
        val title: AppCompatTextView = itemView.findViewById(R.id.tvShowCaseTitle)
        val description: AppCompatTextView = itemView.findViewById(R.id.tvShowCaseDescription)
        val btnPurchase: AppCompatImageButton = itemView.findViewById(R.id.btnPurchase)

    }
}