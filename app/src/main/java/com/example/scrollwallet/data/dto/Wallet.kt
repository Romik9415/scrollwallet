package com.example.scrollwallet.data.dto

//"address":"0x6c9a2fd96616dca3f2d19ff021ae23d1d6d6c007",
//"updated_at":"2024-04-28T21:43:26.751899980Z",
//"next_update_at":"2024-04-28T21:48:26.751900490Z",
//"quote_currency":"USD",
//"chain_id":1,
//"chain_name":"eth-mainnet",
data class Wallet(
    val address: String,
    val updated_at: String,
    val next_update_at: String,
    val quote_currency: String,
    val chain_id: Int,
    val chain_name: String,
    val items: List<WalletItem>
)