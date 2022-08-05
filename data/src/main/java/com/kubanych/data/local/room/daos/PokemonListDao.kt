package com.kubanych.data.local.room.daos

import androidx.paging.PagingSource
import androidx.room.*
import com.kubanych.data.local.room.entities.PokemonEntity

@Dao
interface PokemonListDao {

    @Query("SELECT * FROM pokemon_entity")
    fun getAllPokemon(): PagingSource<Int, PokemonEntity>

    @Query("DELETE FROM pokemon_entity")
    suspend fun deleteAllPokemon()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPokemon(pokemon: List<PokemonEntity>)

    /**
     * Refresh data(delete old data - save new data)
     */
    @Transaction
    suspend fun refresh(pokemon: List<PokemonEntity>) {
        deleteAllPokemon()
        insertAllPokemon(pokemon)
    }
}