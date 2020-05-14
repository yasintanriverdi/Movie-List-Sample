package com.yasintanriverdi.core.network.services

import com.yasintanriverdi.core.network.responses.PopularMoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    suspend fun fetchMovies(@Query("page") page: Int): Response<PopularMoviesResponse>
}