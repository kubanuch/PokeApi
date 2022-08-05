package com.kubanych.pokeapi.presentation.ui.fragments.pokemon.detail

import android.annotation.SuppressLint
import android.graphics.Color
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kubanych.core.base.BaseFragment
import com.kubanych.core.extension.loadImageCoil
import com.kubanych.core.extension.overrideOnBackPressed
import com.kubanych.pokeapi.R
import com.kubanych.pokeapi.databinding.FragmentPokemonDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailFragment : BaseFragment<FragmentPokemonDetailBinding, PokemonDetailViewModel>(
    R.layout.fragment_pokemon_detail
) {
    override val binding by viewBinding(FragmentPokemonDetailBinding::bind)
    override val viewModel by viewModels<PokemonDetailViewModel>()
    private val args by navArgs<PokemonDetailFragmentArgs>()

    /**
     * Override on back pressed function
     */
    override fun setupListeners() {
        overrideOnBackPressed {
            findNavController().navigateUp()
        }
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun setupRequests() {
        viewModel.getPokemonByName(args.name)
    }

    /**
     * Collect StateFlow and set data to items from xml
     */
    @SuppressLint("ResourceType", "SetTextI18n")
    override fun setupCollects() {
        viewModel.pokemonDetailState.collectUIState(
            error = {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.no_connection_text),
                    Toast.LENGTH_SHORT
                ).show()
                binding.root.isVisible = false
            },
            success = {
                binding.root.isVisible = true
                val brightColor = it.color.replace("4D", "FF")
                binding.attackStat.text = "${it.attackBaseStat}/300"
                binding.defenseStat.text = "${it.defenseBaseStat}/300"
                binding.hpStat.text = "${it.hpBaseStat}/300"
                binding.detailTvWeight.text = it.weight.toString()
                binding.detailTvHeight.text = it.height.toString()
                binding.detailHpStat.progress = it.hpBaseStat
                binding.detailAttackStat.progress = it.attackBaseStat
                binding.detailDefenseStat.progress = it.defenseBaseStat
                binding.detailType.setBackgroundColor(Color.parseColor(brightColor))
                it.types.forEach { typesUI ->
                    binding.detailType.text = typesUI.type.name
                }
                binding.heightContainer.strokeColor = Color.parseColor(brightColor)
                binding.weightContainer.strokeColor = Color.parseColor(brightColor)
                binding.rootCardView.setCardBackgroundColor(Color.parseColor(it.color))
                binding.rootCardView.strokeColor = Color.parseColor(brightColor)
                binding.detailIv.loadImageCoil(
                    it.sprites.other.officialArtwork.frontDefault,
                    R.drawable.unknown_pokemon
                )
            }
        )
    }
}