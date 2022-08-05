package com.kubanych.data.local.room.entities.mapper

import com.kubanych.data.local.room.entities.PokemonEntity
import com.kubanych.domain.models.PokemonModel

/**
 * Mapper file for map models from entity to domain
 */

fun PokemonEntity.toDomain() = PokemonModel(
    id, name, url, image, type, color, attackStat, defenseStat, hpStat
)