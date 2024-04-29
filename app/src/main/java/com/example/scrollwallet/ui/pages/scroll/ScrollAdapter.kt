package com.example.scrollwallet.ui.pages.scroll

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.scrollwallet.data.dto.Scroll
import com.example.scrollwallet.data.dto.WalletItem
import com.example.scrollwallet.ui.pages.home.tokens.WalletItemViewHolder

class ScrollAdapter : ListAdapter<Scroll, ScrollViewHolder>(ReservationsDiffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScrollViewHolder =
        ScrollViewHolder.newInstance(parent)

    override fun onBindViewHolder(holder: ScrollViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    fun getItems(): List<Scroll> {
        return currentList
    }

}

object ReservationsDiffUtils : DiffUtil.ItemCallback<Scroll>() {
    override fun areItemsTheSame(
        oldItem: Scroll,
        newItem: Scroll,
    ): Boolean {
        return true
        //return oldItem. == newItem.id
    }

    override fun areContentsTheSame(oldItem: Scroll, newItem: Scroll) =
        oldItem.isItemIsSame(newItem)
}