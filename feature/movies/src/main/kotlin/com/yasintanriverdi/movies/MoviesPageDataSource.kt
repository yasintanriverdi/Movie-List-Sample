package com.yasintanriverdi.movies

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.yasintanriverdi.core.data.DataState
import com.yasintanriverdi.core.data.Result
import com.yasintanriverdi.core.data.entities.Movie
import com.yasintanriverdi.core.repositories.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MoviesPageDataSource @Inject constructor(
    private val moviesRepository: MovieRepository,
    private val scope: CoroutineScope,
    private val dispatcher: CoroutineDispatcher
) : PageKeyedDataSource<Int, Movie>() {

    val dataState = MutableLiveData<DataState>()
    private var retry: (() -> Unit)? = null

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Movie>
    ) {
        dataState.postValue(DataState.Loading)
        scope.launch(dispatcher) {
            when (val response = moviesRepository.fetchMovies(1)) {
                is Result.Success -> {
                    val movies = response.data
                    callback.onResult(movies, null, 2)
                    dataState.postValue(DataState.Success)
                }
                is Result.Error -> {
                    retry = { loadInitial(params, callback) }
                    dataState.postValue(DataState.Error(response.message))
                }
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        val page = params.key
        dataState.postValue(DataState.Loading)
        scope.launch(dispatcher) {
            when (val response = moviesRepository.fetchMovies(page)) {
                is Result.Success -> {
                    val movies = response.data
                    callback.onResult(movies, page + 1)
                    dataState.postValue(DataState.Success)
                }
                is Result.Error -> {
                    retry = { loadAfter(params, callback) }
                    dataState.postValue(DataState.Error(response.message))
                }
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) = Unit

    fun retry() {
        retry?.invoke()
    }
}