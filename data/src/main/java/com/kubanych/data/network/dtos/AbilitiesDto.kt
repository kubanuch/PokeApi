package com.kubanych.data.network.dtos

import com.google.gson.annotations.SerializedName

data class AbilitiesDto(
    @SerializedName("is_hidden")
    val isHidden: Boolean,
    @SerializedName("slot")
    val slot: Int,
    @SerializedName("ability")
    val ability: AbilityDto,
)