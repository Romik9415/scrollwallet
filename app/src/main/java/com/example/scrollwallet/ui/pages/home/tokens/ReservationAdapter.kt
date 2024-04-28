package com.example.scrollwallet.ui.pages.home.tokens

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.scrollwallet.data.dto.WalletItem

class ReservationAdapter() : ListAdapter<WalletItem, WalletItemViewHolder>(ReservationsDiffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletItemViewHolder =
        WalletItemViewHolder.newInstance(parent)

    override fun onBindViewHolder(holder: WalletItemViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    fun getItems(): List<WalletItem> {
        return currentList
    }

}

object ReservationsDiffUtils : DiffUtil.ItemCallback<WalletItem>() {
    override fun areItemsTheSame(
        oldItem: WalletItem,
        newItem: WalletItem,
    ): Boolean {
        return true
        //return oldItem. == newItem.id
    }

    override fun areContentsTheSame(oldItem: WalletItem, newItem: WalletItem) =
        oldItem.isItemIsSame(newItem)
}