package com.kubanych.core.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Base class for [RecyclerView]'s ViewHolders
 */
abstract class BaseRecyclerViewHolder<out V : ViewBinding, in I : Any>(
    val binding: V
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun onBind(item: I): Unit?
}