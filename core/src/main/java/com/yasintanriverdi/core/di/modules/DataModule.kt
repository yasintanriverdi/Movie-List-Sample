package com.yasintanriverdi.core.di.modules

import com.yasintanriverdi.core.data.AppCoroutineDispatchers
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideCoroutineDispatchers() =
        AppCoroutineDispatchers(
            io = Dispatchers.IO,
            computation = Dispatchers.Default,
            main = Dispatchers.Main
        )
}