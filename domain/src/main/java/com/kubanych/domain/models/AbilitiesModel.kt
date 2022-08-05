package com.kubanych.domain.models

data class AbilitiesModel(
    val isHidden: Boolean,
    val slot: Int,
    val ability: AbilityModel,
)