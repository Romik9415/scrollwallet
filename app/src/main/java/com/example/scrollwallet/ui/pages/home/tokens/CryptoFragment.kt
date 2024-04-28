package com.example.scrollwallet.ui.pages.home.tokens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.scrollwallet.R
import com.example.scrollwallet.databinding.FragmentCryptoBinding
import com.example.scrollwallet.ui.base.BaseFragment
import com.example.scrollwallet.ui.extentions.viewBindingWithBinder

class CryptoFragment : BaseFragment(R.layout.fragment_crypto) {
    val binding by viewBindingWithBinder(FragmentCryptoBinding::bind)
    private val viewModel: CryptoViewModel by viewModels()

    override fun initViewModel() {
        viewModel.crypto.observe(this) {
            val wallet = it.data?: return@observe
        }
        viewModel.getWalletData()
    }

    override fun onViewReady(inflatedView: View, args: Bundle?) {

    }

    override fun setListeners() {

    }
}