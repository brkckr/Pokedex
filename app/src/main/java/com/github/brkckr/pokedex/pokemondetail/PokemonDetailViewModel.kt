package com.github.brkckr.pokedex.pokemondetail

import androidx.lifecycle.ViewModel
import com.github.brkckr.pokedex.data.remote.response.Pokemon
import com.github.brkckr.pokedex.repository.PokemonRepository
import com.github.brkckr.pokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}