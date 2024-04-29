package com.example.scrollwallet.data.dto

data class Scroll(
    val id: Int
) {
    fun isItemIsSame(newItem: Scroll): Boolean {
        return this == newItem
    }
}