package com.yasintanriverdi.core.di.modules

import android.content.Context
import androidx.room.Room
import com.yasintanriverdi.core.BuildConfig
import com.yasintanriverdi.core.database.MovieDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideMovieDatabase(context: Context) =
        Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            BuildConfig.MOVIE_DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun provideMovieDao(movieDatabase: MovieDatabase) =
        movieDatabase.movieDao()
}