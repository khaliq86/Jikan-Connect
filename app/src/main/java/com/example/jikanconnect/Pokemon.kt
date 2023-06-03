package com.example.jikanconnect

import com.squareup.moshi.Json

data class Pokemon(
    @Json(name = "title")
    val name: String,
    @Json(name = "duration")
    val duration: String,
    @Json(name = "images")
    val images: Images
)

data class Images(
    val jpg: Jpg,
    val webp: Webp
)

data class Jpg(
    @Json(name = "image_url")
    val image_url: String,
    val small_image_url: String,
    val large_image_url: String

)

data class Webp(
    val image_url: String,
    val small_image_url: String,
    val large_image_url: String
)

data class PokemonResponse(
    @Json(name = "data")
    val pokemonList: List<Pokemon>
)
