package com.yasintanriverdi.core.repositories

import com.yasintanriverdi.core.data.Result
import com.yasintanriverdi.core.data.entities.Movie
import com.yasintanriverdi.core.datasource.remote.MovieRemoteDataSource
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource
) {

    suspend fun fetchMovies(page: Int): Result<List<Movie>> {
        return remoteDataSource.fetchMovies(page)
    }
}