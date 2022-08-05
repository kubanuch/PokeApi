package com.kubanych.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kubanych.data.local.room.daos.PokemonListDao
import com.kubanych.data.local.room.entities.PokemonEntity

@Database(entities = [PokemonEntity::class],
    version = 13,
    exportSchema = false)
abstract class PokeDatabase : RoomDatabase() {

    abstract fun pokemonListDao(): PokemonListDao
}