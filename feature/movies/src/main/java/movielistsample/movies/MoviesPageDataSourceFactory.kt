package movielistsample.movies

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.yasintanriverdi.core.data.entities.Movie
import javax.inject.Inject
import javax.inject.Provider

class MoviesPageDataSourceFactory @Inject constructor(
    private val moviePageDataSourceProvider: Provider<MoviesPageDataSource>
) : DataSource.Factory<Int, Movie>() {

    val sourceLiveData = MutableLiveData<MoviesPageDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = moviePageDataSourceProvider.get()
        sourceLiveData.postValue(movieDataSource)
        return movieDataSource
    }

    fun retry() {
        sourceLiveData.value?.retry()
    }
}