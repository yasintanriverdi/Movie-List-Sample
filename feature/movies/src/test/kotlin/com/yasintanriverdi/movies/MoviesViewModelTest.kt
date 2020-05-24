package com.yasintanriverdi.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.yasintanriverdi.core.data.DataState
import com.yasintanriverdi.testcommons.rules.CoroutineTestRule
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MoviesViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @MockK(relaxed = true)
    lateinit var dataSourceFactory: MoviesPageDataSourceFactory

    @MockK(relaxed = true)
    lateinit var stateObserver: Observer<MoviesViewState>

    @MockK(relaxed = true)
    lateinit var eventObserver: Observer<MoviesEvent>

    lateinit var viewModel: MoviesViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `state is success when data state is success`() {
        val dataState = DataState.Success
        val fakePageDataSource = FakeMoviesPageDataSource(dataState)
        val fakeSourceLiveData = MutableLiveData<MoviesPageDataSource>(fakePageDataSource)
        every {
            dataSourceFactory.sourceLiveData
        } returns fakeSourceLiveData

        viewModel = MoviesViewModel(pageDataSourceFactory = dataSourceFactory)
        viewModel.state.observeForever(stateObserver)

        val expectedState = MoviesViewState(dataState = dataState)
        assertEquals(expectedState, viewModel.state.value)
        verify { stateObserver.onChanged(expectedState) }
    }

    @Test
    fun `state is error when data state is error`() {
        val dataState = DataState.Error(message = "")
        val fakePageDataSource = FakeMoviesPageDataSource(dataState)
        val fakeSourceLiveData = MutableLiveData<MoviesPageDataSource>(fakePageDataSource)
        every {
            dataSourceFactory.sourceLiveData
        } returns fakeSourceLiveData

        viewModel = MoviesViewModel(pageDataSourceFactory = dataSourceFactory)
        viewModel.state.observeForever(stateObserver)

        val expectedState = MoviesViewState(dataState = dataState)
        assertEquals(expectedState, viewModel.state.value)
        verify { stateObserver.onChanged(expectedState) }
    }

    @Test
    fun `state is loading when data state is loading`() {
        val dataState = DataState.Loading
        val fakePageDataSource = FakeMoviesPageDataSource(dataState)
        val fakeSourceLiveData = MutableLiveData<MoviesPageDataSource>(fakePageDataSource)
        every {
            dataSourceFactory.sourceLiveData
        } returns fakeSourceLiveData

        viewModel = MoviesViewModel(pageDataSourceFactory = dataSourceFactory)
        viewModel.state.observeForever(stateObserver)

        val expectedState = MoviesViewState(dataState = dataState)
        assertEquals(expectedState, viewModel.state.value)
        verify { stateObserver.onChanged(expectedState) }
    }

    @Test
    fun `retry is invoked properly`() {
        viewModel = MoviesViewModel(pageDataSourceFactory = dataSourceFactory)
        viewModel.retry()

        verify { dataSourceFactory.retry() }
    }

    @Test
    fun `open detail is invoked properly`() {
        viewModel = MoviesViewModel(pageDataSourceFactory = dataSourceFactory)
        viewModel.event.observeForever(eventObserver)

        val movieId = 123
        val movieTitle = "movie-123"
        viewModel.openMovieDetail(movieId, movieTitle)

        val event = MoviesEvent.OpenMovieDetail(movieId, movieTitle)
        assertEquals(event, viewModel.event.value)
        verify { eventObserver.onChanged(event) }
    }

    inner class FakeMoviesPageDataSource(
        dataState: DataState
    ) : MoviesPageDataSource(
        moviesRepository = mockk(),
        scope = mockk()
    ) {
        init {
            this.dataState.postValue(dataState)
        }
    }
}