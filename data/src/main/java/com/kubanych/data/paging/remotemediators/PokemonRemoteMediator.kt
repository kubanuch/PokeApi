package com.kubanych.data.paging.remotemediators

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.kubanych.data.local.room.daos.PokemonListDao
import com.kubanych.data.local.room.entities.PokemonEntity
import com.kubanych.data.local.room.entities.mapper.toEntity
import com.kubanych.data.network.api.PokemonApiService
import com.kubanych.data.network.dtos.AboutPokemonDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * RemoteMediator for save data directly from network to the room
 */
@OptIn(ExperimentalPagingApi::class)
class PokemonRemoteMediator(
    private val apiService: PokemonApiService,
    private val dao: PokemonListDao,
    private val limit: Int,
) : RemoteMediator<Int, PokemonEntity>() {

    private var pageNumber = 0
    private var attackStat = 0
    private var defenseStat = 0
    private var hpStat = 0

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PokemonEntity>,
    ): MediatorResult {

        pageNumber =
            getPageOffset(loadType) ?: return MediatorResult.Success(endOfPaginationReached = true)

        val offset = pageNumber * limit

        return try {
            val data = getPokemon(offset)

            if (loadType == LoadType.REFRESH) {
                dao.refresh(data)
            } else {
                dao.insertAllPokemon(data)
            }
            MediatorResult.Success(endOfPaginationReached = data.size < limit)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }

    /**
     * Request on getPokemon with offset and limit params
     * Map getPokemon for do request on getPokemonByName
     */
    private suspend fun getPokemon(offset: Int): List<PokemonEntity> {
        return withContext(Dispatchers.IO) {
            apiService.getPokemon(offset, limit).results.map {
                val info = apiService.getPokemonByName(it.name)
                setStats(info)
                it.toEntity(info.types[0].type.name, attackStat, defenseStat, hpStat)
            }
        }
    }

    private fun setStats(info: AboutPokemonDto) {
        info.stats.forEach { statsDto ->
            when (statsDto.stat.name) {
                "hp" -> hpStat = statsDto.baseStat
                "attack" -> attackStat = statsDto.baseStat
                "defense" -> defenseStat = statsDto.baseStat
            }
        }
    }

    /**
     * Function for get offset page on under different loading states
     */
    private fun getPageOffset(loadType: LoadType): Int? {
        pageNumber = when (loadType) {
            LoadType.REFRESH -> 0
            LoadType.PREPEND -> return null
            LoadType.APPEND -> ++pageNumber
        }
        return pageNumber
    }
}