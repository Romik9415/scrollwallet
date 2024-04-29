package com.example.scrollwallet.data.dto

data class Scroll(
    val id: Int,
    var text: String? = null
) {
    fun isItemIsSame(newItem: Scroll): Boolean {
        return this == newItem
    }
}