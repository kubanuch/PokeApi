package com.kubanych.domain.usecases

import com.kubanych.domain.repositories.PokemonRepository
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val repository: PokemonRepository,
) {

    operator fun invoke() = repository.getPokemon()
}