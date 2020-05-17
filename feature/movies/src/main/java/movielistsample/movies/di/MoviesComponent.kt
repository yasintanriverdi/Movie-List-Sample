package movielistsample.movies.di

import com.yasintanriverdi.core.di.CoreComponent
import com.yasintanriverdi.core.di.scopes.FeatureScope
import dagger.Component
import movielistsample.movies.MoviesFragment

@FeatureScope
@Component(
    modules = [MoviesModule::class],
    dependencies = [CoreComponent::class])
interface MoviesComponent {
    fun inject(moviesFragment: MoviesFragment)
}