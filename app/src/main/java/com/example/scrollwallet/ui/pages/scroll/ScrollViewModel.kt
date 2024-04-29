package com.example.scrollwallet.ui.pages.scroll

import com.example.scrollwallet.BaseViewModel
import com.example.scrollwallet.ui.pages.home.LocalWalletRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScrollViewModel @Inject constructor(
    private val localWalletRepo: LocalWalletRepo
) : BaseViewModel() {

    val currentRollsLiveData = localWalletRepo.currentRollsLiveData

    suspend fun rollsIncrease() {
        localWalletRepo.rollsIncrease()
    }

    suspend fun updateRolls(totalItemsViewed: Int) {
        localWalletRepo.rollsIncrease(totalItemsViewed)
    }
}