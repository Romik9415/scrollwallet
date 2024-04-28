package com.example.scrollwallet.ui.pages.scroll

import android.os.Bundle
import android.view.View
import com.example.scrollwallet.R
import com.example.scrollwallet.databinding.ScrollFragmentBinding
import com.example.scrollwallet.ui.base.BaseFragment
import com.example.scrollwallet.ui.extentions.addSystemTopPadding
import com.example.scrollwallet.ui.extentions.viewBindingWithBinder

class ScrollFragment : BaseFragment(R.layout.scroll_fragment), View.OnClickListener {

    private val binding by viewBindingWithBinder(ScrollFragmentBinding::bind)

    override fun initViewModel() {

    }

    override fun onViewReady(inflatedView: View, args: Bundle?) {

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
}