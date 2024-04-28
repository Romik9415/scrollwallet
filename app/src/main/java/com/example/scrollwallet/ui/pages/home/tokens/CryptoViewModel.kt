package com.example.scrollwallet.ui.pages.home.tokens

import androidx.lifecycle.MutableLiveData
import com.example.scrollwallet.BaseViewModel
import com.example.scrollwallet.data.dto.Wallet
import com.example.scrollwallet.data.network.repository.RemoteWalletRepo
import com.example.scrollwallet.data.network.responses.CovalentResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(
    private val remoteWalletRepo: RemoteWalletRepo
) : BaseViewModel() {

    val crypto = MutableLiveData<CovalentResponse<Wallet>>()

    fun getWalletData() {
        launchHandled(
            task = {
                remoteWalletRepo.getWalletData()
            },
            onSuccess = { result ->
                crypto.postValue(result)
            },
            onError = {
                //handle error
            }
        )
    }
}