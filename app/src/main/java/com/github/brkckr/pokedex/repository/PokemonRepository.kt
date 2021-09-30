package com.github.brkckr.pokedex.repository

import com.github.brkckr.pokedex.data.remote.PokeApi
import com.github.brkckr.pokedex.data.remote.response.Pokemon
import com.github.brkckr.pokedex.data.remote.response.PokemonList
import com.github.brkckr.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("error")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("error")
        }
        return Resource.Success(response)
    }
}