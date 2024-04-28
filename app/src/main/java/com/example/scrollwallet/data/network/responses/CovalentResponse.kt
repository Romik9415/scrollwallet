package com.example.scrollwallet.data.network.responses

data class CovalentResponse<T>(
    val data: T,
    val error: Boolean,
    val error_message: String?,
    val error_code: Int?
)