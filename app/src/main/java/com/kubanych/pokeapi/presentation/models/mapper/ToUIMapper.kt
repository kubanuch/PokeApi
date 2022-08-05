package com.kubanych.pokeapi.presentation.models.mapper

import com.kubanych.domain.models.*
import com.kubanych.pokeapi.presentation.models.*

/**
 * Mapper file for map from domain models to ui models
 */

fun PokemonModel.toUI() = PokemonUI(
    id = id,
    name = name,
    url = url,
    image = image,
    color = color,
    type = type,
    attackStat = attackStat,
    defenseStat = defenseStat,
    hpStat = hpStat
)

fun AboutPokemon.toUI() = AboutPokemonUI(
    abilities.map {
        it.toUI()
    },
    baseExperience,
    forms.map {
        it.toUI()
    },
    height,
    id,
    isDefault,
    locationAreaEncounters,
    name,
    order,
    species.toUI(),
    sprites.toUI(),
    attackBaseStat,
    defenseBaseStat,
    hpBaseStat,
    types.map {
        it.toUI()
    },
    weight,
    color
)

fun AbilitiesModel.toUI() = AbilitiesUI(
    isHidden, slot, ability.toUI()
)

fun AbilityModel.toUI() = AbilityUI(
    name, url
)

fun FormsModel.toUI() = FormsUI(
    name, url
)

fun SpeciesModel.toUI() = SpeciesUI(name, url)

fun SpritesModel.toUI() = SpritesUI(
    frontShinyFemale,
    frontDefault,
    frontFemale,
    frontShiny,
    other.toUI()
)

fun TypesModel.toUI() = TypesUI(slot, type.toUI())

fun TypeModel.toUI() = TypeUI(name, url)

fun OtherModel.toUI() = OtherUI(
    dreamWorld.toUI(),
    officialArtwork.toUI()
)

fun DreamWorldModel.toUI() = DreamWorldUI(
    frontDefault
)

fun OfficialArtworkModel.toUI() = OfficialArtworkUI(
    frontDefault
)



