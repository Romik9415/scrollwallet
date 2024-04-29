package com.example.scrollwallet.ui.pages.scroll

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.scrollwallet.data.dto.Scroll
import com.example.scrollwallet.databinding.RvSrollBinding

class ScrollViewHolder(
    private val binding: RvSrollBinding,
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(item: Scroll) {
        binding.tvId.text = item.text
    }


    companion object {
        fun newInstance(
            parent: ViewGroup
        ) = ScrollViewHolder(
            RvSrollBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
}
