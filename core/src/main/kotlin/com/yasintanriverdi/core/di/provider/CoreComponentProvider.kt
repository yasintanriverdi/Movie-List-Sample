package com.yasintanriverdi.core.di.provider

import com.yasintanriverdi.core.di.CoreComponent

interface CoreComponentProvider {
    fun provideCoreComponent(): CoreComponent
}