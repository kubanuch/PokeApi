package com.kubanych.domain.models

data class PokemonResponse<T>(
    val next: String?,
    val previous: String?,
    val count: Int,
    val results: List<T>,
)