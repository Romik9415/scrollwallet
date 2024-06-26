package com.example.scrollwallet.data.dto

import kotlin.math.pow

//"contract_decimals":18,
//            "contract_name":"ether.fi ETH",
//            "contract_ticker_symbol":"eETH",
//            "contract_address":"0x35fa164735182de50811e8e2e824cfb9b6118ac2",
//            "supports_erc":[
//               "erc20"
//            ],
//            "logo_url":"https://logos.covalenthq.com/tokens/1/0x35fa164735182de50811e8e2e824cfb9b6118ac2.png",
//            "contract_display_name":"ether.fi ETH",
//            "logo_urls":{
//               "token_logo_url":"https://logos.covalenthq.com/tokens/1/0x35fa164735182de50811e8e2e824cfb9b6118ac2.png",
//               "protocol_logo_url":null,
//               "chain_logo_url":"https://www.datocms-assets.com/86369/1669653891-eth.svg"
//            },
//            "last_transferred_at":"2024-03-11T06:15:47Z",
//            "native_token":false,
//            "type":"cryptocurrency",
//            "is_spam":false,
//            "balance":"45505666079690310629",
//            "balance_24h":"45505666079690310629",
//            "quote_rate":3306.676,
//            "quote_rate_24h":3280.005,
//            "quote":150472.5,
//            "pretty_quote":"$150,472.50",
//            "quote_24h":149258.81,
//            "pretty_quote_24h":"$149,258.81",
//            "protocol_metadata":null,
//            "nft_data":null
data class WalletItem(
//    val contract_decimals: Int?,
//    val contract_name: String,
    val contract_ticker_symbol: String?,
//    val contract_address: String,
//    val supports_erc: List<String?>?,
    val logo_url: String,
    val contract_display_name: String?,
    val logo_urls: LogoUrls,
//    val last_transferred_at: String,
//    val native_token: Boolean,
//    val type: String,
//    val is_spam: Boolean,
    val balance: String,
//    val balance_24h: String,
    val quote_rate: Double?,
    val quote_rate_24h: Double?,
//    val quote: Double,
    val pretty_quote: String?,
//    val quote_24h: Double,
//    val pretty_quote_24h: String,
//    val protocol_metadata: String?,
//    val nft_data: String?
) {
    fun isItemIsSame(newItem: WalletItem): Boolean {
        return this == newItem
    }

    //4765197696161521209
    fun getBalanceStr(): String {
        return balance
//            .toBigDecimalOrNull()?.let {
//            val decimals = 18
//            val balance = it / 10.0.pow(decimals)
//            balance.toString()
//        } ?: "?"
    }
}
