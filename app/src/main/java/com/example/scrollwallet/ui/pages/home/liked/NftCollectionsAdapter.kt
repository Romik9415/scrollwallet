package com.example.scrollwallet.ui.pages.home.liked

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class DropsCollectionsAdapter(private val onItemClicked: OnNftClicked) :
    ListAdapter<NftCollectionItem, NftCollectionViewHolder>(NftCollectionItemDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NftCollectionViewHolder {
        return NftCollectionViewHolder.newInstance(parent, onItemClicked)
    }

    override fun onBindViewHolder(holder: NftCollectionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

object NftCollectionItemDiffCallback : DiffUtil.ItemCallback<NftCollectionItem>() {
    override fun areItemsTheSame(oldItem: NftCollectionItem, newItem: NftCollectionItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: NftCollectionItem,
        newItem: NftCollectionItem
    ): Boolean {
        return false
    }
}
