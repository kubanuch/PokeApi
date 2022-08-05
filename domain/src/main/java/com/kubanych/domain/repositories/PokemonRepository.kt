package com.kubanych.domain.repositories

import androidx.paging.PagingData
import com.kubanych.common.either.Either
import com.kubanych.domain.models.AboutPokemon
import com.kubanych.domain.models.PokemonModel
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokemon(): Flow<PagingData<PokemonModel>>

    fun getPokemonByName(name: String): Flow<Either<String, AboutPokemon>>
}