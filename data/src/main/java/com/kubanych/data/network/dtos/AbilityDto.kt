package com.kubanych.data.network.dtos

import com.google.gson.annotations.SerializedName

data class AbilityDto(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?,
)