package com.kubanych.pokeapi.presentation.ui.fragments.pokemon.detail

import com.kubanych.core.base.BaseViewModel
import com.kubanych.domain.usecases.GetPokemonByNameUseCase
import com.kubanych.pokeapi.presentation.models.AboutPokemonUI
import com.kubanych.pokeapi.presentation.models.mapper.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonByIdUseCase: GetPokemonByNameUseCase,
) : BaseViewModel() {

    private val _pokemonDetailState = mutableStateFlow<AboutPokemonUI>()
    val pokemonDetailState = _pokemonDetailState.asStateFlow()

    fun getPokemonByName(name: String) {
        collectState(_pokemonDetailState, getPokemonByIdUseCase(name)) {
            it.toUI()
        }
    }
}