package com.kubanych.data.repositories.impl

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.map
import com.kubanych.core.base.BaseRepository
import com.kubanych.data.local.room.daos.PokemonListDao
import com.kubanych.data.local.room.entities.mapper.toDomain
import com.kubanych.data.network.api.PokemonApiService
import com.kubanych.data.network.dtos.mapper.toDomain
import com.kubanych.data.paging.remotemediators.PokemonRemoteMediator
import com.kubanych.domain.repositories.PokemonRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val apiService: PokemonApiService,
    private val dao: PokemonListDao,
) : BaseRepository(), PokemonRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun getPokemon() = Pager(
        config = PagingConfig(
            pageSize = LIMIT,
            prefetchDistance = 10,
            enablePlaceholders = true,
            initialLoadSize = LIMIT
        ),
        remoteMediator = PokemonRemoteMediator(apiService, dao, LIMIT),
        pagingSourceFactory = { dao.getAllPokemon() }
    ).flow.map { pagingData ->
        pagingData.map {
            it.toDomain()
        }
    }

    override fun getPokemonByName(name: String) = doRequest {
        apiService.getPokemonByName(name).toDomain()
    }

    /**
     * Limit of one page
     */
    companion object {
        const val LIMIT = 30
    }
}