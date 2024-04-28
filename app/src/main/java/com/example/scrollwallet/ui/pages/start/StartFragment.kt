package com.example.scrollwallet.ui.pages.start

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.scrollwallet.R
import com.example.scrollwallet.databinding.StartFragmentBinding
import com.example.scrollwallet.ui.base.BaseFragment
import com.example.scrollwallet.ui.extentions.viewBindingWithBinder
import com.example.scrollwallet.ui.navigation.Screens

class StartFragment : BaseFragment(R.layout.start_fragment), OnClickListener {

    private val binding by viewBindingWithBinder(StartFragmentBinding::bind)
    override fun initViewModel() {

    }

    override fun onViewReady(inflatedView: View, args: Bundle?) {

    }

    override fun setListeners() {
        binding.bStart.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.bStart -> {
                router.navigateTo(Screens.navigateHomeScreen())
            }
        }
    }
}