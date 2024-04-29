package com.example.scrollwallet.ui.pages.home

import com.example.scrollwallet.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    localWalletRepo: LocalWalletRepo
) : BaseViewModel() {

    val currentRollsLiveData = localWalletRepo.currentRollsLiveData

}