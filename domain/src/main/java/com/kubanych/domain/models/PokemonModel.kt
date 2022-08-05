package com.kubanych.domain.models

data class PokemonModel(
    val id: Int,
    val name: String,
    val url: String,
    val image: String,
    val type: String?,
    val color: Int,
    val attackStat: Int?,
    val defenseStat: Int?,
    val hpStat: Int?,
)