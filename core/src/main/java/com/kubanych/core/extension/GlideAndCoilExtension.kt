package com.kubanych.core.extension

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.annotation.IdRes
import coil.ImageLoader
import coil.request.ImageRequest
import com.bumptech.glide.Glide

/**
 * Glide library extension for load image
 * */
@SuppressLint("ResourceType")
fun ImageView.loadImage(url: String?, @IdRes placeHolder: Int, errorImage: String?) {
    Glide.with(this.context)
        .load(url)
        .placeholder(placeHolder)
        .error(errorImage)
        .into(this)
}

/**
 * Coil library extension for load image
 * */
@SuppressLint("ResourceType")
fun ImageView.loadImageCoil(url: String?, @IdRes placeHolder: Int) {
    val imageLoader = ImageLoader.Builder(this.context)
        .crossfade(false)
        .build()

    val request = ImageRequest.Builder(this.context)
        .data(url)
        .size(200, 200)
        .placeholder(placeHolder)
        .target(this)
        .build()
    imageLoader.enqueue(request)
}

