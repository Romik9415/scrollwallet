package com.example.scrollwallet.data.dto

//"token_logo_url":"https://logos.covalenthq.com/tokens/1/0x35fa164735182de50811e8e2e824cfb9b6118ac2.png",
////               "protocol_logo_url":null,
////               "chain_logo_url":"https://www.datocms-assets.com/86369/1669653891-eth.svg"
data class LogoUrls(
    val token_logo_url: String,
    val protocol_logo_url: String?,
    val chain_logo_url: String
)
