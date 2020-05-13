package com.yasintanriverdi.core.network.services

import com.yasintanriverdi.core.network.responses.PopulerMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    fun fetchMovies(@Query("page") page: Int): PopulerMoviesResponse
}