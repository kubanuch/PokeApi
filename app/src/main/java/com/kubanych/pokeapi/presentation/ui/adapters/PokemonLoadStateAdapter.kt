package com.kubanych.pokeapi.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kubanych.pokeapi.databinding.ItemLoadStateBinding

/**
 * Footer adapter for PagingDataAdapter with a progressbar and retry button
 */
class PokemonLoadStateAdapter(val retry: () -> Unit) :
    LoadStateAdapter<PokemonLoadStateAdapter.LoadStateViewHolder>() {

    inner class LoadStateViewHolder(val binding: ItemLoadStateBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        return LoadStateViewHolder(
            ItemLoadStateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.binding.apply {
            itemProgressBar.isVisible = loadState is LoadState.Loading
            btnRetry.isVisible = loadState is LoadState.Error
            btnRetry.setOnClickListener {
                retry()
            }
        }
    }
}