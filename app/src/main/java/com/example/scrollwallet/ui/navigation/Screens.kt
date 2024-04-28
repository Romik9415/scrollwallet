package com.example.scrollwallet.ui.navigation

import com.example.scrollwallet.ui.pages.home.HomeFragment
import com.example.scrollwallet.ui.pages.scroll.ScrollFragment
import com.example.scrollwallet.ui.pages.start.StartFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun navigateStartScreen() = FragmentScreen { StartFragment() }
    fun navigateHomeScreen() = FragmentScreen { HomeFragment() }
    fun navigateToScrollScreen() = FragmentScreen { ScrollFragment() }

}