package com.kubanych.pokeapi.di

import android.content.Context
import androidx.room.Room
import com.kubanych.data.local.room.PokeDatabase
import com.kubanych.data.local.room.daos.PokemonListDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    /**
     * Provide a singleton Poke's Database instance
     */
    @Singleton
    @Provides
    fun providePokeDatabase(@ApplicationContext context: Context): PokeDatabase =
        Room.databaseBuilder(
            context,
            PokeDatabase::class.java,
            "poke_api_database"
        ).fallbackToDestructiveMigration().build()

    /**
     * Provide a singleton instance of DAO for interact with Pokémon
     */
    @Provides
    @Singleton
    fun providePokemonListDao(pokeDatabase: PokeDatabase): PokemonListDao =
        pokeDatabase.pokemonListDao()
}