package com.example.scrollwallet.ui.extentions

import android.content.res.Resources

val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

val Float.dp: Float
    get() = this * Resources.getSystem().displayMetrics.density

val Int.toDp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()