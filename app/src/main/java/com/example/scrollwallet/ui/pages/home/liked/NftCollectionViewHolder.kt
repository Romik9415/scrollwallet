package com.example.scrollwallet.ui.pages.home.liked

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.scrollwallet.databinding.RvGridNftBinding
import com.example.scrollwallet.ui.extentions.loadWithGlide

class NftCollectionViewHolder(
    private val binding: RvGridNftBinding,
    val onItemClicked: OnNftClicked
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(collectionItem: NftCollectionItem) {
//        binding.tvCollectionName.text = collectionItem.name
        binding.imageView4.loadWithGlide(collectionItem.imageUrl)
        binding.root.setOnClickListener {
            onItemClicked.onItemClicked()
        }
    }

    companion object {
        fun newInstance(parent: ViewGroup, onItemClicked: OnNftClicked) =
            NftCollectionViewHolder(
                RvGridNftBinding.inflate(LayoutInflater.from(parent.context), parent, false),
                onItemClicked
            )
    }
}
