package movielistsample.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.yasintanriverdi.commons.ui.SingleLiveData
import com.yasintanriverdi.core.data.entities.Movie
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    dataSourceFactory: MoviesDataSourceFactory
) : ViewModel() {

    private val pagedListConfig =
        PagedList.Config.Builder()
            .setInitialLoadSizeHint(20)
            .setEnablePlaceholders(true)
            .setPageSize(20)
            .build()

    private val dataState = Transformations.switchMap(dataSourceFactory.sourceLiveData) {
        it.dataState
    }

    internal val data: LiveData<PagedList<Movie>> =
        LivePagedListBuilder(dataSourceFactory, pagedListConfig).build()

    val state = Transformations.map(dataState) { MoviesViewState(dataState = it) }

    private val _event = SingleLiveData<MoviesEvent>()
    val event: LiveData<MoviesEvent>
        get() = _event

    fun openMovieDetail(movieId: Int) {
        _event.value = MoviesEvent.OpenMovieDetail(movieId)
    }
}