package com.example.scrollwallet.ui.pages.home

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.scrollwallet.R
import com.example.scrollwallet.ui.pages.home.liked.LikedFragment

class ProfileViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    val listOFragments = listOf<Pair<@StringRes Int, Fragment>>(
        Pair(R.string.crypto, LikedFragment()),
        Pair(R.string.nfts, LikedFragment()),
    )

    override fun getItemCount(): Int = listOFragments.size

    override fun createFragment(position: Int): Fragment {
        return listOFragments[position].second
    }
}