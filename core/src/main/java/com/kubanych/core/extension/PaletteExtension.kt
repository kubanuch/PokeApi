package com.kubanych.core.extension

import com.kubanych.core.utils.TypeColors

/**
 * Extension, gives colors based on Pokemon type
 */
fun getTypeColor(type: String? = null): String {
    return when (type) {
        "fire" -> TypeColors.Fire.color
        "water" -> TypeColors.Water.color
        "electric" -> TypeColors.Electric.color
        "grass" -> TypeColors.Grass.color
        "ice" -> TypeColors.Ice.color
        "fighting" -> TypeColors.Fighting.color
        "poison" -> TypeColors.Poison.color
        "ground" -> TypeColors.Ground.color
        "flying" -> TypeColors.Flying.color
        "psychic" -> TypeColors.Psychic.color
        "bug" -> TypeColors.Bug.color
        "rock" -> TypeColors.Rock.color
        "ghost" -> TypeColors.Ghost.color
        "dragon" -> TypeColors.Dragon.color
        "dark" -> TypeColors.Dark.color
        "steel" -> TypeColors.Steel.color
        "fairy" -> TypeColors.Fairy.color
        else -> TypeColors.Normal.color
    }
}