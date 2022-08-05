package com.kubanych.core.base

import androidx.recyclerview.widget.DiffUtil

/**
 * Base class for [DiffUtil]
 * Data is compared via interface
 */
class BaseDiffUtilItemCallback<T : IBaseDiffModel> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}
/**
 * У тебя все получется
 * я верю в тебя
 * не здавайся
 */