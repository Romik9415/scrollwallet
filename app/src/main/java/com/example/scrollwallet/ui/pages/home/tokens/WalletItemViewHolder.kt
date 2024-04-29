package com.example.scrollwallet.ui.pages.home.tokens

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.scrollwallet.data.dto.WalletItem
import com.example.scrollwallet.databinding.RvItemCryptoBinding
import com.example.scrollwallet.ui.extentions.loadWithGlideCircleCrop

class WalletItemViewHolder(
    private val binding: RvItemCryptoBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: WalletItem) {
        binding.tvTokenName.text = item.contract_ticker_symbol
        binding.tvPrice.text = "$ " + item.quote_rate.toString()
        binding.tvTokenTotalPrice.text = item.getBalanceStr()
        binding.tvTokenValue.text = item.pretty_quote
        val tokenLogo = item.logo_urls.token_logo_url
        binding.ivTokenIcon.loadWithGlideCircleCrop(tokenLogo)
    }


    companion object {
        fun newInstance(
            parent: ViewGroup
        ) = WalletItemViewHolder(
            RvItemCryptoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
}
