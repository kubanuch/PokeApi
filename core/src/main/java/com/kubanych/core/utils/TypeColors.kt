package com.kubanych.core.utils

/**
 * All types of Pokemon
 *
 * All colors based on Pokemon type
 */
sealed class TypeColors(val color: String) {
    object Normal : TypeColors("#4DA8A77A")
    object Fire : TypeColors("#4DEE8130")
    object Water : TypeColors("#4D6390F0")
    object Electric : TypeColors("#4DF7D02C")
    object Grass : TypeColors("#4D7AC74C")
    object Ice : TypeColors("#4D96D9D6")
    object Fighting : TypeColors("#4DC22E28")
    object Poison : TypeColors("#4DA33EA1")
    object Ground : TypeColors("#4DE2BF65")
    object Flying : TypeColors("#4DE2BF65")
    object Psychic : TypeColors("#4DF95587")
    object Bug : TypeColors("#4DA6B91A")
    object Rock : TypeColors("#4DB6A136")
    object Ghost : TypeColors("#4D735797")
    object Dragon : TypeColors("#4D6F35FC")
    object Dark : TypeColors("#4D705746")
    object Steel : TypeColors("#4DB7B7CE")
    object Fairy : TypeColors("#4DD685AD")
}