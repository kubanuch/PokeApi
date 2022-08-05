package com.kubanych.data.network.dtos

import com.google.gson.annotations.SerializedName

data class DreamWorldDto(
    @SerializedName("front_default")
    val frontDefault: String?,
)