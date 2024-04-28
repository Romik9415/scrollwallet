package com.example.scrollwallet.ui.pages.home

import com.example.scrollwallet.BaseViewModel
import com.example.scrollwallet.data.network.repository.RemoteWalletRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val remoteWalletRepo: RemoteWalletRepo
) : BaseViewModel() {
}