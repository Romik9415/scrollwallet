package com.example.scrollwallet.ui.pages.notifications

import android.os.Bundle
import android.view.View
import com.example.scrollwallet.R
import com.example.scrollwallet.databinding.NotificationFragmentBinding
import com.example.scrollwallet.ui.base.BaseFragment
import com.example.scrollwallet.ui.extentions.addSystemTopPadding
import com.example.scrollwallet.ui.extentions.viewBindingWithBinder

class NotificationFragment : BaseFragment(R.layout.notification_fragment) {
    val binding by viewBindingWithBinder(NotificationFragmentBinding::bind)
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