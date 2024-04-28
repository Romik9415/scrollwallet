package com.example.scrollwallet.ui.extentions

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

//todo need to move to coil https://github.com/coil-kt/coil
//https://coil-kt.github.io/coil/recipes/

fun ImageView.loadWithGlide(url: String?, @DrawableRes placeholderResId: Int? = null) {
    Glide.with(context).load(url).also { glideRequest ->
        placeholderResId?.let {
            glideRequest.placeholder(it)
        }
        glideRequest.into(this)
    }
}


fun ImageView.loadWithGlideCropCenter(url: String?, @DrawableRes placeholderResId: Int? = null) {
    Glide.with(context).load(url).also { glideRequest ->
        placeholderResId?.let {
            glideRequest.placeholder(it)
        }
        glideRequest
            .centerCrop()
            .into(this)
    }
}

fun ImageView.loadWithGlideCropCenter(
    @DrawableRes resId: Int?,
    @DrawableRes placeholderResId: Int? = null
) {
    Glide.with(context).load(resId).also { glideRequest ->
        placeholderResId?.let {
            glideRequest.placeholder(it)
        }
        glideRequest
            .centerCrop()
            .into(this)
    }
}

fun ImageView.loadWithGlide(url: Drawable?, @DrawableRes placeholderResId: Int? = null) {
    Glide.with(context).load(url).also { glideRequest ->
        placeholderResId?.let {
            glideRequest.placeholder(it)
        }
        glideRequest.into(this)
    }
}

fun ImageView.loadWithGlide(@DrawableRes resId: Int?, @DrawableRes placeholderResId: Int? = null) {
    Glide.with(context).load(resId).also { glideRequest ->
        placeholderResId?.let {
            glideRequest.placeholder(it)
        }
        glideRequest.into(this)
    }
}

fun ImageView.loadWithGlideCircleCrop(url: String?, @DrawableRes placeholderId: Int? = null) {
    Glide.with(this.context.applicationContext).load(url).also { glideRequest ->
        placeholderId?.let {
            glideRequest.placeholder(it)
        }
        glideRequest
            .apply(RequestOptions.circleCropTransform())
            .into(this)
    }
}

fun ImageView?.loadWithGlideRoundedCorners(
    @DrawableRes resId: Int?,
    radius: Int,
    placeholderId: Int? = null
) {
    var requestOptions = RequestOptions()
    // requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(radius))
    requestOptions = requestOptions.transform(RoundedCorners(radius))

    if (this != null) {
        placeholderId?.let {
            Glide.with(this.context)
                .load(resId)
                .placeholder(it)
                .apply(requestOptions)
                .error(it)
                .fallback(it)
                .into(this)
        }
    }
}

fun ImageView?.loadWithGlideRoundedCorners(url: String?, radius: Int, placeholderId: Int? = null) {
    var requestOptions = RequestOptions()
    requestOptions = requestOptions.transform(CenterCrop(), RoundedCorners(radius))

    if (this != null) {
        Glide.with(context).load(url).also { glideRequest ->
            placeholderId?.let {
                glideRequest
                    .placeholder(it)
                    .error(it)
                    .fallback(it)
            }
            glideRequest
                .apply(requestOptions)
                .into(this)
        }
    }
}

fun ImageView?.loadWithGlideRoundedCorners(
    bitmap: Bitmap?,
    radius: Int,
    placeholderId: Int? = null
) {
    var requestOptions = RequestOptions()
    requestOptions = requestOptions.transform(CenterCrop(), RoundedCorners(radius))

    if (this != null) {
        Glide.with(context).load(bitmap).also { glideRequest ->
            placeholderId?.let {
                glideRequest
                    .placeholder(it)
                    .error(it)
                    .fallback(it)
            }
            glideRequest
                .apply(requestOptions)
                .into(this)
        }
    }
}

