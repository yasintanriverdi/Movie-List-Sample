package movielistsample.movies

import android.content.Context
import androidx.fragment.app.Fragment
import com.yasintanriverdi.commons.extensions.appContext
import com.yasintanriverdi.core.di.provider.CoreComponentProvider
import com.yasintanriverdi.movies.R
import movielistsample.movies.di.DaggerMoviesComponent
import movielistsample.movies.di.MoviesModule
import javax.inject.Inject

class MoviesFragment : Fragment(R.layout.fragment_movies) {

    @Inject
    lateinit var viewModel: MoviesViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerMoviesComponent
            .builder()
            .coreComponent((appContext as CoreComponentProvider).provideCoreComponent())
            .moviesModule(MoviesModule(this))
            .build()
            .inject(this)
    }
}