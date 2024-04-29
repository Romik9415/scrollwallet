package com.example.scrollwallet.ui.pages.settings

import android.os.Bundle
import android.view.View
import com.example.scrollwallet.R
import com.example.scrollwallet.databinding.SettingsFragmentBinding
import com.example.scrollwallet.ui.base.BaseFragment
import com.example.scrollwallet.ui.extentions.addSystemTopPadding
import com.example.scrollwallet.ui.extentions.viewBindingWithBinder

class SettingsFragment : BaseFragment(R.layout.settings_fragment) {

    val binding by viewBindingWithBinder(SettingsFragmentBinding::bind)


    override fun initViewModel() {

    }

    override fun onViewReady(inflatedView: View, args: Bundle?) {

    }

    override fun setListeners() {

    }

    override fun setInsetForFragment() {
        binding.llToolbar.addSystemTopPadding()
    }
}