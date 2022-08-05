package com.kubanych.data.network.dtos

import com.google.gson.annotations.SerializedName

data class AboutPokemonDto(
    @SerializedName("abilities")
    val abilities: List<AbilitiesDto>,
    @SerializedName("base_experience")
    val baseExperience: Int,
    @SerializedName("forms")
    val forms: List<FormsDto>,
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_default")
    val isDefault: Boolean,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("species")
    val species: SpeciesDto,
    @SerializedName("sprites")
    val sprites: SpritesDto,
    @SerializedName("stats")
    val stats: List<StatsDto>,
    @SerializedName("types")
    val types: List<TypesDto>,
    @SerializedName("weight")
    val weight: Int,
)