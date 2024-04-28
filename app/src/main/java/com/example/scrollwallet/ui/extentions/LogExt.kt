package com.example.scrollwallet.ui.extentions

import android.util.Log
//import com.example.scrollwallet.BuildConfig

fun logd(tag: String, text: String?) {
    //if (!BuildConfig.DEBUG) return
    Log.d(tag, text.toString())
}

fun loge(tag: String, text: String?, tr: Exception?) {
    //if (!BuildConfig.DEBUG) return
    Log.e(tag, text, tr)
}

fun loge(tag: String, text: String?) {
    //if (!BuildConfig.DEBUG) return
    Log.e(tag, text.toString())
}