package com.kubanych.data.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_entity")
data class PokemonEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "type")
    val type: String?,
    @ColumnInfo(name = "color")
    val color: Int,
    @ColumnInfo(name = "attack_stat")
    val attackStat: Int?,
    @ColumnInfo(name = "defense_stat")
    val defenseStat: Int?,
    @ColumnInfo(name = "hp_stat")
    val hpStat: Int?
)

