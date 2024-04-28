package com.example.scrollwallet.data.network.api

import com.example.scrollwallet.data.dto.Wallet
import com.example.scrollwallet.data.network.responses.CovalentResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query

interface BaseApi {
    ///{chainName}/address/{walletAddress}/balances_v2/
//    @Headers("API_KEY: cqt_rQDk7GptHtGPJtdpgtDBVpmP6Pjr")
    //https://api.covalenthq.com/v1/{chainName}/nft/{contractAddress}/metadata/
    //https://api.covalenthq.com/v1/eth-mainnet/address/0x6c9A2fd96616Dca3F2D19fF021ae23d1d6d6c007/balances_v2/?key=cqt_rQDk7GptHtGPJtdpgtDBVpmP6Pjr
    @GET("eth-mainnet/address/0x6c9A2fd96616Dca3F2D19fF021ae23d1d6d6c007/balances_v2/")
    suspend fun getWalletInfo(@Query("key") apiKey: String): Response<CovalentResponse<Wallet>>

//    @GET("api/communities/{$COMMUNITY_ID}/users/me/token")
//    suspend fun getUserTokenForCommunity(
//        @Path(COMMUNITY_ID) communityId: String
//    ): Response<UserTokenResponseBody>
//
//    @GET("api/users/username-by-phone/{$PHONE_PATH}")
//    suspend fun getUserNameByPhone(
//        @Path(PHONE_PATH) phone: String
//    ): Response<UserNameResponseBody>
//
//    @GET("api/users/me")
//    suspend fun getUser(): Response<User>
//
//    @PATCH("api/users")
//    suspend fun updateUserImg(): Response<User>
//
//    companion object {
//        const val COMMUNITY_ID = "communityId"
//        const val PHONE_PATH = "phone"
//    }
}