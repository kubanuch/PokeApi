package com.kubanych.data.network.dtos.mapper

import com.kubanych.core.extension.getTypeColor
import com.kubanych.data.network.dtos.*
import com.kubanych.domain.models.*

/**
 * Mapper file for map models from data to domain
 */

fun AboutPokemonDto.toDomain() = AboutPokemon(
    abilities.map {
        it.toDomain()
    },
    baseExperience,
    forms.map {
        it.toDomain()
    },
    height,
    id,
    isDefault,
    locationAreaEncounters,
    name,
    order,
    species.toDomain(),
    sprites.toDomain(),
    statAttack(stats),
    statDefense(stats),
    statHP(stats),
    types.map {
        it.toDomain()
    },
    weight,
    getTypeColor(types[0].type.name)
)

fun AbilitiesDto.toDomain() = AbilitiesModel(
    isHidden, slot, ability.toDomain()
)

fun AbilityDto.toDomain() = AbilityModel(
    name, url
)

fun FormsDto.toDomain() = FormsModel(
    name, url
)

fun SpeciesDto.toDomain() = SpeciesModel(name, url)

fun SpritesDto.toDomain() = SpritesModel(
    frontShinyFemale,
    frontDefault,
    frontFemale,
    frontShiny,
    other.toDomain()
)

fun TypesDto.toDomain() = TypesModel(slot, type.toDomain())

fun TypeDto.toDomain() = TypeModel(name, url)

fun OtherDto.toDomain() = OtherModel(
    dreamWorld.toDomain(),
    officialArtwork.toDomain()
)

fun DreamWorldDto.toDomain() = DreamWorldModel(
    frontDefault
)

fun OfficialArtworkDto.toDomain() = OfficialArtworkModel(
    frontDefault
)

fun statAttack(stats: List<StatsDto>): Int {
    var stat = 0
    stats.map {
        if (it.stat.name == "attack") {
            stat = it.baseStat
        }
    }
    return stat
}

fun statDefense(stats: List<StatsDto>): Int {
    var stat = 0
    stats.map {
        if (it.stat.name == "defense") {
            stat = it.baseStat
        }
    }
    return stat
}

fun statHP(stats: List<StatsDto>): Int {
    var stat = 0
    stats.map {
        if (it.stat.name == "hp") {
            stat = it.baseStat
        }
    }
    return stat
}