package com.example.scrollwallet.ui.pages.home.tokens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scrollwallet.R
import com.example.scrollwallet.databinding.FragmentCryptoBinding
import com.example.scrollwallet.ui.base.BaseFragment
import com.example.scrollwallet.ui.extentions.viewBindingWithBinder

class CryptoFragment : BaseFragment(R.layout.fragment_crypto) {
    val binding by viewBindingWithBinder(FragmentCryptoBinding::bind)
    private val viewModel: CryptoViewModel by viewModels()

    private var reservationAdapter = ReservationAdapter()

    override fun initViewModel() {
        viewModel.crypto.observe(this) {
            val wallet = it.data
            reservationAdapter.submitList(wallet.items)
        }
        viewModel.getWalletData()
    }

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        with(binding.rvCrypto) {
            adapter = reservationAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun setListeners() {

    }

    override fun setInsetForFragment() {
        //do nothing
    }
}