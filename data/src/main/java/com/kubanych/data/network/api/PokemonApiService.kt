package com.kubanych.data.network.api

import com.kubanych.data.network.dtos.AboutPokemonDto
import com.kubanych.data.network.dtos.PokemonDto
import com.kubanych.data.network.dtos.PokemonResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {

    /**
     * Request which return Pokemon with the possibility of pagination
     */
    @GET("pokemon")
    suspend fun getPokemon(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): PokemonResponseDto<PokemonDto>

    /**
     * Request which return one Pokemon by Name
     */
    @GET("pokemon/{name}")
    suspend fun getPokemonByName(
        @Path("name") name: String,
    ): AboutPokemonDto
}