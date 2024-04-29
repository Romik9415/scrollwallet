package com.example.scrollwallet.ui.pages.scroll

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.scrollwallet.R
import com.example.scrollwallet.databinding.ScrollFragmentBinding
import com.example.scrollwallet.ui.base.BaseFragment
import com.example.scrollwallet.ui.extentions.addSystemTopPadding
import com.example.scrollwallet.ui.extentions.viewBindingWithBinder
import com.robinhood.ticker.TickerUtils

class ScrollFragment : BaseFragment(R.layout.scroll_fragment), View.OnClickListener {
    private val viewModel: ScrollViewModel by viewModels()

    private val binding by viewBindingWithBinder(ScrollFragmentBinding::bind)

    override fun initViewModel() {
        viewModel.currentRollsLiveData.observe(this) {
            binding.tvUserDescription.text = getBalanceString(it?.rolls)
        }
    }

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        binding.tvUserDescription.apply {
            setCharacterLists(TickerUtils.provideNumberList())
            animationDuration = 800
        }
    }

    override fun setListeners() {
        binding.ivBack.setOnClickListener(this)
    }

    override fun setInsetForFragment() {
        binding.llToolbar.addSystemTopPadding()
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.ivBack -> router.exit()
        }
    }

    private fun getBalanceString(currentRollBalance: Double?): String {
        if (currentRollBalance == null) return "0.000 ROLL"
        return String.format("%.3f", currentRollBalance) + " ROLL"
    }
}