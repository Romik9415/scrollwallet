package com.example.scrollwallet.data.network


import okhttp3.Interceptor
import okhttp3.Response
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

open class RequestHeaderInterceptor : Interceptor {


    @OptIn(ExperimentalEncodingApi::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder =
            request.newBuilder().apply {
                addHeader("Accept", "application/json")
//                val session = runBlocking {
//                    (auth.fetchAuthSession() as AWSCognitoAuthSession).userPoolTokens
//                }
//                addHeader(
//                    "“Authorization",
//                    "Basic " + Base64.encode("cqt_rQDk7GptHtGPJtdpgtDBVpmP6Pjr".toByteArray()).toString()
//                )
                //session.value?.idToken?.let { addHeader(HEADER_TOKEN, it) }
            }
        return chain.proceed(builder.build())
    }

    companion object {
        const val HEADER_TOKEN = "X-Authorization"
    }

}