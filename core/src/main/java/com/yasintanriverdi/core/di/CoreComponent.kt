package com.yasintanriverdi.core.di

import android.content.Context
import com.yasintanriverdi.core.data.AppCoroutineDispatchers
import com.yasintanriverdi.core.database.MovieDao
import com.yasintanriverdi.core.di.modules.ContextModule
import com.yasintanriverdi.core.di.modules.DispatcherModule
import com.yasintanriverdi.core.di.modules.DatabaseModule
import com.yasintanriverdi.core.di.modules.NetworkModule
import com.yasintanriverdi.core.network.services.MovieService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        DispatcherModule::class
    ]
)
interface CoreComponent {

    fun context(): Context

    fun movieService(): MovieService

    fun movieDao(): MovieDao

    fun coroutineDispatchers(): AppCoroutineDispatchers
}