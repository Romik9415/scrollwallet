package com.example.scrollwallet.data.network.repository

import com.example.scrollwallet.data.dto.Wallet
import com.example.scrollwallet.data.network.api.BaseApi
import com.example.scrollwallet.data.network.responses.CovalentResponse
import javax.inject.Inject

class RemoteWalletRepo @Inject constructor(
    private val api: BaseApi
) {
    suspend fun getWalletData(): CovalentResponse<Wallet>? {
        val walletInfo = api.getWalletInfo("cqt_rQDk7GptHtGPJtdpgtDBVpmP6Pjr")
        if (walletInfo.isSuccessful) {
            return walletInfo.body()
        } else {
            throw Exception("Failed to get wallet info")
        }

    }
}