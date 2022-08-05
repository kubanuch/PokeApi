package com.kubanych.data.network.dtos

import com.google.gson.annotations.SerializedName
import com.kubanych.data.network.dtos.DreamWorldDto
import com.kubanych.data.network.dtos.OfficialArtworkDto

data class OtherDto(
    @SerializedName("dream_world")
    val dreamWorld: DreamWorldDto,
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtworkDto,
)