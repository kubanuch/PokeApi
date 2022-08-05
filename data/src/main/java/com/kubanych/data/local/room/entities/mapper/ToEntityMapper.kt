package com.kubanych.data.local.room.entities.mapper

import android.graphics.Color
import com.kubanych.core.extension.getTypeColor
import com.kubanych.data.local.room.entities.PokemonEntity
import com.kubanych.data.network.dtos.PokemonDto

/**
 * Mapper file for map models from data to entity
 */

fun PokemonDto.toEntity(type: String?, attackStat: Int, defenseStat: Int, hpStat: Int) =
    PokemonEntity(
        id = getId(url),
        name = name,
        url = url,
        image = getImage(getId(url)),
        type = type,
        color = Color.parseColor(getTypeColor(type)),
        attackStat = attackStat,
        defenseStat = defenseStat,
        hpStat = hpStat
    )


/**
 * Get Pokemon id from url
 */
fun getId(url: String): Int {
    return url.replace("/", "").replace("https:pokeapi.coapiv2pokemon", "").toInt()
}

fun getImage(id: Int): String {
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
}