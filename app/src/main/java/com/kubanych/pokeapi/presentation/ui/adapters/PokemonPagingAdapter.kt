package com.kubanych.pokeapi.presentation.ui.adapters

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.paging.PagingDataAdapter
import com.kubanych.core.base.BaseDiffUtilItemCallback
import com.kubanych.core.base.BaseRecyclerViewHolder
import com.kubanych.core.extension.loadImage
import com.kubanych.pokeapi.R
import com.kubanych.pokeapi.databinding.ItemPokemonBinding
import com.kubanych.pokeapi.presentation.models.PokemonUI

class PokemonPagingAdapter(val onItemClick: (name: String) -> Unit) :
    PagingDataAdapter<PokemonUI, PokemonPagingAdapter.PokemonViewHolder>(
        BaseDiffUtilItemCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            ItemPokemonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class PokemonViewHolder(binding: ItemPokemonBinding) :
        BaseRecyclerViewHolder<ItemPokemonBinding, PokemonUI>(binding) {
        @RequiresApi(Build.VERSION_CODES.O)
        @SuppressLint("ResourceType")
        override fun onBind(item: PokemonUI) = with(binding) {
            itemPokemonName.text = item.name.replaceFirstChar { it.uppercase() }

            /**
             * set image to ImageView with extension Glide library
             */
            itemPokemonImage.loadImage(
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${item.id}.png",
                R.drawable.unknown_pokemon,
                item.image
            )

            binding.cardView.setCardBackgroundColor(item.color)

            itemView.setOnClickListener {
                onItemClick(item.name)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position >= itemCount) LOADING else POKEMON
    }

    companion object {
        const val LOADING = 0
        const val POKEMON = 1
    }
}