package com.kubanych.data.network.dtos

import com.google.gson.annotations.SerializedName

data class PokemonResponseDto<T>(
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("count")
    val count: Int,
    @SerializedName("results")
    val results: List<T>,
)