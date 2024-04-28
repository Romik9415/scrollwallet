package com.example.scrollwallet.ui.extentions

import android.content.Context
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.scrollwallet.R
import com.example.scrollwallet.ui.base.FragmentAutoClearedValueBinding

inline fun <T : ViewBinding> AppCompatActivity.viewBinding(
    crossinline bindingInflater: (LayoutInflater) -> T
) = lazy(LazyThreadSafetyMode.NONE) {
    bindingInflater.invoke(layoutInflater)
}

fun <T : ViewBinding> Fragment.viewBindingWithBinder(
    binder: (View) -> T
) = FragmentAutoClearedValueBinding(binder)

fun Fragment.toastL(text: String) {
    Toast.makeText(activity?.applicationContext, text, Toast.LENGTH_LONG).show()
}

fun Fragment.toastSh(text: String) {
    Toast.makeText(activity?.applicationContext, text, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(@StringRes resId: Int) {
    showToast(getString(resId))
}

fun Fragment.showToast(text: String) {
    Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
}