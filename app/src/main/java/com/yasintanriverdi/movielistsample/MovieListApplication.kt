package com.yasintanriverdi.movielistsample

import android.app.Application
import android.content.Context
import com.yasintanriverdi.core.di.CoreComponent
import com.yasintanriverdi.core.di.DaggerCoreComponent
import com.yasintanriverdi.core.di.modules.ContextModule
import com.yasintanriverdi.movielistsample.di.DaggerAppComponent

class MovieListApplication : Application() {

    lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        initDependencyInjection()
    }

    private fun initDependencyInjection() {
        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()

        DaggerAppComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this)
    }

    companion object {

        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as? MovieListApplication)?.coreComponent
    }
}