package com.kubanych.data.network.dtos

import com.google.gson.annotations.SerializedName
import com.kubanych.data.network.dtos.TypeDto

data class TypesDto(
    @SerializedName("slot")
    val slot: Int,
    @SerializedName("type")
    val type: TypeDto,
)