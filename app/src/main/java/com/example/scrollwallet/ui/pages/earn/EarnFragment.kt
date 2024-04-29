package com.example.scrollwallet.ui.pages.earn

import android.os.Bundle
import android.view.View
import com.example.scrollwallet.R
import com.example.scrollwallet.databinding.EarnFragmentBinding
import com.example.scrollwallet.ui.base.BaseFragment
import com.example.scrollwallet.ui.extentions.addSystemTopPadding
import com.example.scrollwallet.ui.extentions.viewBindingWithBinder
import com.example.scrollwallet.ui.navigation.Screens
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EarnFragment : BaseFragment(R.layout.earn_fragment), View.OnClickListener {
    val binding by viewBindingWithBinder(EarnFragmentBinding::bind)


    override fun initViewModel() {

    }

    override fun onViewReady(inflatedView: View, args: Bundle?) {

    }

    override fun setListeners() {
        binding.ivBack.setOnClickListener(this)
        binding.cardViewSponsor1.setOnClickListener(this)
        binding.cardViewSponsor2.setOnClickListener(this)
    }

    override fun setInsetForFragment() {
        binding.llToolbar.addSystemTopPadding()
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.ivBack -> router.exit()
            binding.cardViewSponsor1 -> router.navigateTo(
                Screens.openUrl(
                    "https://t.me/CovalentHQ"
                )
            )

            binding.cardViewSponsor2 -> router.navigateTo(
                Screens.openUrl(
                    "https://twitter.com/Scroll_ZKP"
                )
            )
        }
    }
}