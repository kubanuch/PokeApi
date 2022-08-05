package com.kubanych.pokeapi.presentation.models

import com.google.gson.annotations.SerializedName

data class StatUI(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?,
)