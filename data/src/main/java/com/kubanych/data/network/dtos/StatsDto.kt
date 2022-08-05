package com.kubanych.data.network.dtos

import com.google.gson.annotations.SerializedName
import com.kubanych.data.network.dtos.StatDto

data class StatsDto(
    @SerializedName("stat")
    val stat: StatDto,
    @SerializedName("base_stat")
    val baseStat: Int,
    @SerializedName("effort")
    val effort: Int,
)