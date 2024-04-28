package com.example.scrollwallet.ui.navigation

interface BackButtonListener {

    /**
     * Return
     * false -> cancel back btn action
     * true -> need to back action
     */

    fun onBackPressed(): Boolean
}