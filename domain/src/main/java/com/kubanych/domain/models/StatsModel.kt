package com.kubanych.domain.models

import com.kubanych.domain.models.StatModel

data class StatsModel(
    val stat: StatModel,
    val baseStat: Int,
    val effort: Int,
)