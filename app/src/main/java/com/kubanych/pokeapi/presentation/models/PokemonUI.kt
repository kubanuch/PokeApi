package com.kubanych.pokeapi.presentation.models

import android.os.Parcelable
import com.kubanych.core.base.IBaseDiffModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonUI(
    override val name: String,
    val url: String,
    val id: Int,
    val image: String,
    val type: String?,
    val color: Int,
    val attackStat: Int?,
    val defenseStat: Int?,
    val hpStat: Int?,
) : IBaseDiffModel, Parcelable