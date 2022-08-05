package com.kubanych.pokeapi.presentation.ui.fragments.pokemon

import android.os.Bundle
import androidx.core.view.forEach
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kubanych.core.base.BaseFragment
import com.kubanych.core.extension.navigateSafely
import com.kubanych.core.utils.LayoutColumnUtil
import com.kubanych.pokeapi.R
import com.kubanych.pokeapi.databinding.FragmentPokemonListBinding
import com.kubanych.pokeapi.databinding.ItemAttributesBinding
import com.kubanych.pokeapi.presentation.ui.adapters.PokemonLoadStateAdapter
import com.kubanych.pokeapi.presentation.ui.adapters.PokemonPagingAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Main fragment with a RecyclerView
 * */
@AndroidEntryPoint
class PokemonListFragment : BaseFragment<FragmentPokemonListBinding, PokemonListViewModel>(
    R.layout.fragment_pokemon_list
) {
    override val binding by viewBinding(FragmentPokemonListBinding::bind)
    override val viewModel by viewModels<PokemonListViewModel>()
    private val pokemonPagingAdapter = PokemonPagingAdapter(this::onItemClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun initialize() {
        setupPagingRecycler()
    }

    /**
     * Set config to a RecyclerView
     * LayoutManager calculate adaptive spanCount for a screen
     */
    private fun setupPagingRecycler() {
        val gridLayoutManager = GridLayoutManager(
            requireContext(),
            LayoutColumnUtil.calculateNoOfColumns(requireContext(), 200f)
        )
        binding.pokemonRecycler.layoutManager = gridLayoutManager
        val loadStateAdapter = PokemonLoadStateAdapter() { pokemonPagingAdapter.retry() }
        binding.pokemonRecycler.adapter = pokemonPagingAdapter.withLoadStateFooter(
            loadStateAdapter
        )
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (
                    pokemonPagingAdapter.getItemViewType(position) == PokemonPagingAdapter.LOADING
                ) 2 else 1
            }
        }
    }

    override fun setupListeners() {
        setupLoadStateListener()
        setupRefreshList()
        setupCheckboxes()
    }

    /**
     * Work with visibility of items in xml on Error
     * or when Loading
     */
    private fun setupLoadStateListener() {
        val attrBinding = ItemAttributesBinding.bind(binding.root)
        pokemonPagingAdapter.addLoadStateListener {
            binding.root.forEach { view ->
                if (view.id == R.id.item_progress_bar) {
                    view.isVisible = true
                } else {
                    view.isVisible = it.refresh !is LoadState.Loading
                }
            }
            attrBinding.itemProgressBar.isVisible = it.refresh is LoadState.Loading
        }
    }


    /**
     * Refresh RecyclerView's adapter on click
     */
    private fun setupRefreshList() {
        binding.btnRefresh.setOnClickListener {
            binding.pokemonRecycler.smoothScrollToPosition(0)
            pokemonPagingAdapter.refresh()
        }
    }

    /**
     * Sort list of Pokemon by descending
     */
    private fun setupCheckboxes() = with(binding) {
        attackCheckbox.setOnCheckedChangeListener { _, b ->
            applyFilter(b, defenseCheckbox.isChecked, hitPointsCheckbox.isChecked)
        }
        defenseCheckbox.setOnCheckedChangeListener { _, b ->
            applyFilter(attackCheckbox.isChecked, b, hitPointsCheckbox.isChecked)
        }

        hitPointsCheckbox.setOnCheckedChangeListener { _, b ->
            applyFilter(attackCheckbox.isChecked, defenseCheckbox.isChecked, b)
        }
    }

    private fun applyFilter(attack: Boolean, defense: Boolean, hp: Boolean) {
        if (attack && defense && hp) {
            lifecycleScope.launch {
                pokemonPagingAdapter.submitData(
                    PagingData.from(pokemonPagingAdapter.snapshot().items.sortedByDescending {
                        it.attackStat!! + it.defenseStat!! + it.hpStat!!
                    })
                )
                scrollUp()
            }
        } else if (attack && defense) {
            lifecycleScope.launch {
                pokemonPagingAdapter.submitData(
                    PagingData.from(pokemonPagingAdapter.snapshot().items.sortedByDescending {
                        it.attackStat!! + it.defenseStat!!
                    })
                )
                scrollUp()
            }
        } else if (defense && hp) {
            lifecycleScope.launch {
                pokemonPagingAdapter.submitData(
                    PagingData.from(
                        pokemonPagingAdapter.snapshot().items.sortedByDescending {
                            it.defenseStat!! + it.hpStat!!
                        })
                )
                scrollUp()
            }
        } else if (attack && hp) {
            lifecycleScope.launch {
                pokemonPagingAdapter.submitData(
                    PagingData.from(
                        pokemonPagingAdapter.snapshot().items.sortedByDescending {
                            it.attackStat!! + it.hpStat!!
                        })
                )
                scrollUp()
            }
        } else if (attack) {
            lifecycleScope.launch {
                pokemonPagingAdapter.submitData(
                    PagingData.from(
                        pokemonPagingAdapter.snapshot().items.sortedByDescending {
                            it.attackStat!!
                        })
                )
                scrollUp()
            }
        } else if (defense) {
            lifecycleScope.launch {
                pokemonPagingAdapter.submitData(
                    PagingData.from(
                        pokemonPagingAdapter.snapshot().items.sortedByDescending {
                            it.defenseStat!!
                        })
                )
                scrollUp()
            }
        } else if (hp) {
            lifecycleScope.launch {
                pokemonPagingAdapter.submitData(
                    PagingData.from(
                        pokemonPagingAdapter.snapshot().items.sortedByDescending {
                            it.hpStat!!
                        })
                )
                scrollUp()
            }
        } else if (!attack && !defense && !hp) {
            viewModel.getPokemon()
        }
    }

    /**
     * Scroll up after two seconds after apply filters
     */
    private suspend fun scrollUp() {
        delay(2000)
        binding.pokemonRecycler.smoothScrollToPosition(0)
    }

    override fun setupCollects() {
        viewModel.pokemonState.collectIdle(
            action = {
                pokemonPagingAdapter.submitData(it)
            }
        )
    }

    /**
     * Navigate to detail screen with name of Pokemon after click
     * */
    private fun onItemClick(name: String) {
        findNavController().navigateSafely(
            PokemonListFragmentDirections.actionPokemonListFragmentToPokemonDetailFragment(name)
        )
    }
}