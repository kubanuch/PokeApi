package com.kubanych.domain.models

data class AboutPokemon(
    val abilities: List<AbilitiesModel>,
    val baseExperience: Int,
    val forms: List<FormsModel>,
    val height: Int,
    val id: Int,
    val isDefault: Boolean,
    val locationAreaEncounters: String?,
    val name: String,
    val order: Int,
    val species: SpeciesModel,
    val sprites: SpritesModel,
    val attackBaseStat: Int,
    val defenseBaseStat: Int,
    val hpBaseStat: Int,
    val types: List<TypesModel>,
    val weight: Int,
    val color: String
)