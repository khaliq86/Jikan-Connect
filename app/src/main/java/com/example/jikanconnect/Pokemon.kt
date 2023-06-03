package com.example.jikanconnect

import com.squareup.moshi.Json

data class Pokemon(
    @Json(name = "title")
    val name: String,
    @Json(name = "duration")
    val duration: String
)

data class PokemonResponse(
    @Json(name = "data")
    val pokemonList: List<Pokemon>
)
