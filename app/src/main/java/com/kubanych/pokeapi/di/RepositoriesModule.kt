package com.kubanych.pokeapi.di

import com.kubanych.data.repositories.impl.PokemonRepositoryImpl
import com.kubanych.domain.repositories.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    /**
     * Binds two repositories dependencies to use both
     */
    @Binds
    fun bindPokemonRepository(repositoryImpl: PokemonRepositoryImpl): PokemonRepository
}