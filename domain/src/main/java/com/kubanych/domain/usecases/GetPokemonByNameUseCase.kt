package com.kubanych.domain.usecases

import com.kubanych.domain.repositories.PokemonRepository
import javax.inject.Inject

class GetPokemonByNameUseCase @Inject constructor(
    private val repository: PokemonRepository,
) {

    operator fun invoke(name: String) = repository.getPokemonByName(name)
}