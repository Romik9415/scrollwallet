package com.example.scrollwallet.ui.pages.home

import com.example.scrollwallet.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val localWalletRepo: LocalWalletRepo
) : BaseViewModel() {
    suspend fun rollsIncrease() {
        localWalletRepo.rollsIncrease()
    }

    val currentRollsLiveData = localWalletRepo.currentRollsLiveData

}