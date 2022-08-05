package com.kubanych.core.base

import androidx.recyclerview.widget.DiffUtil

/**
 * [DiffUtil] interface
 */
interface IBaseDiffModel {
    val name: String?
    override fun equals(other: Any?): Boolean
}