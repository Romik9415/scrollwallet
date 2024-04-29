package com.example.scrollwallet.ui.navigation

import android.content.Intent
import android.net.Uri
import com.example.scrollwallet.ui.pages.home.HomeFragment
import com.example.scrollwallet.ui.pages.scroll.ScrollFragment
import com.example.scrollwallet.ui.pages.start.StartFragment
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun navigateStartScreen() = FragmentScreen { StartFragment() }
    fun navigateHomeScreen() = FragmentScreen { HomeFragment() }
    fun navigateToScrollScreen() = FragmentScreen { ScrollFragment() }

    fun openUrl(uriStr: String) = ActivityScreen {
        Intent(Intent.ACTION_VIEW, Uri.parse(uriStr))
    }
}