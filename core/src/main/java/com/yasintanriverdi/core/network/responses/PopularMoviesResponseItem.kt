package com.yasintanriverdi.core.network.responses

import com.squareup.moshi.Json

data class PopularMoviesResponseItem(
    val id: Int,
    @field:Json(name = "poster_path") val posterUrl: String?,
    val overview: String?,
    @field:Json(name = "release_date") val releaseDate: String?,
    val title: String
)