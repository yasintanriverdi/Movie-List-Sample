package com.yasintanriverdi.moviedetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.yasintanriverdi.core.data.DataState
import com.yasintanriverdi.core.data.entities.Movie
import com.yasintanriverdi.core.repositories.MovieRepository
import com.yasintanriverdi.testcommons.rules.CoroutineTestRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verifyOrder
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MovieDetailViewModelTest {

    @get:Rule
    var coroutineTestRule = CoroutineTestRule()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @RelaxedMockK
    lateinit var repository: MovieRepository

    lateinit var viewModel: MovieDetailViewModel

    @MockK(relaxed = true)
    lateinit var stateObserver: Observer<MovieDetailViewState>

    @MockK(relaxed = true)
    lateinit var dataObserver: Observer<Movie>

    val movieId = 1
    val movie = Movie(id = movieId, title = "m-title", overview = "m-o", posterUrl = "m-p")

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = MovieDetailViewModel(repository)
    }

    @Test
    fun `state order is proper when data state is success`() =
        coroutineTestRule.dispatcher.runBlockingTest {
            coEvery {
                repository.getMovieById(movieId)
            } returns movie

            viewModel.state.observeForever(stateObserver)

            viewModel.fetchMovie(movieId)

            verifyOrder {
                stateObserver.onChanged(MovieDetailViewState(DataState.Loading))
                stateObserver.onChanged(MovieDetailViewState(DataState.Success))
            }
        }

    @Test
    fun `fetch movie properly`() = coroutineTestRule.dispatcher.runBlockingTest {
        coEvery {
            repository.getMovieById(movieId)
        } returns movie

        viewModel.data.observeForever(dataObserver)

        viewModel.fetchMovie(movieId)

        verifyOrder {
            dataObserver.onChanged(movie)
        }
    }

    @Test
    fun `state is error when there is no movie`() = coroutineTestRule.dispatcher.runBlockingTest {
        coEvery {
            repository.getMovieById(movieId)
        } returns null

        viewModel.state.observeForever(stateObserver)

        viewModel.fetchMovie(movieId)

        verifyOrder {
            stateObserver.onChanged(MovieDetailViewState(DataState.Loading))
            stateObserver.onChanged(
                MovieDetailViewState(DataState.Error(MovieDetailViewModel.ERROR_MESSAGE)))
        }
    }
}