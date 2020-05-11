package com.yasintanriverdi.core.di

import android.content.Context
import com.yasintanriverdi.core.di.modules.ContextModule
import com.yasintanriverdi.core.di.modules.DatabaseModule
import com.yasintanriverdi.core.di.modules.NetworkModule
import com.yasintanriverdi.core.network.repositories.MovieRepository
import com.yasintanriverdi.core.network.services.MovieService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class,
        DatabaseModule::class
    ]
)
interface CoreComponent {

    fun context(): Context

    fun movieService(): MovieService

    fun movieRepository(): MovieRepository
}