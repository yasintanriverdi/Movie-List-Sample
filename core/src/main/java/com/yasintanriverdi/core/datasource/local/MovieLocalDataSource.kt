package com.yasintanriverdi.core.datasource.local

import com.yasintanriverdi.core.data.entities.Movie
import com.yasintanriverdi.core.database.MovieDao
import javax.inject.Inject

class MovieLocalDataSource @Inject constructor(
    private val movieDao: MovieDao
) {

    suspend fun insertAll(movies: List<Movie>) {
        movieDao.insertAll(movies)
    }

    suspend fun getMovieById(movieId: Int) = movieDao.getMovieById(movieId)
}