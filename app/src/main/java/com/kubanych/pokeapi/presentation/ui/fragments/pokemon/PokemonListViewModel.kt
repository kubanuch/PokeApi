package com.kubanych.pokeapi.presentation.ui.fragments.pokemon

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.kubanych.core.base.BaseViewModel
import com.kubanych.domain.usecases.GetPokemonUseCase
import com.kubanych.pokeapi.presentation.models.PokemonUI
import com.kubanych.pokeapi.presentation.models.mapper.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase,
) : BaseViewModel() {

    private val _pokemonState = MutableStateFlow<PagingData<PokemonUI>>(PagingData.empty())
    val pokemonState = _pokemonState.asStateFlow()

    /**
     * Start request on init ViewModel
     */
    init {
        getPokemon()
    }

    /**
     * Collecting data from a flow and setting it to StateFlow
     * */
    fun getPokemon() = collectIdle(
        _pokemonState,
        getPokemonUseCase().cachedIn(viewModelScope)
    ) { pagingData ->
        pagingData.map {
            it.toUI()
        }
    }
}