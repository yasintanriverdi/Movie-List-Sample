import com.yasintanriverdi.movielistsample.buildsrc.utils.getLocalProperty

plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinKapt)
}

android {
    buildTypes.forEach {
        it.buildConfigField(
            type = "String",
            name = "TMDB_API_BASE_URL", value = "https://api.themoviedb.org/3/"
        )
        it.buildConfigField(
            type = "String",
            name = "TMDB_API_KEY", value = getLocalProperty("TMDB_API_KEY", project)
        )
        it.buildConfigField(type = "String", name = "MOVIE_DATABASE_NAME", value = "movies-db")
        it.buildConfigField(type = "int", name = "MOVIE_DATABASE_VERSION", value = "1")
    }
}

dependencies {

    implementation(Dependencies.Kotlin.stdlib)

    implementation(Dependencies.Kotlin.Coroutines.core)

    // AndroidX
    implementation(Dependencies.AndroidX.Room.core)
    kapt(Dependencies.AndroidX.Room.compiler)
    implementation(Dependencies.AndroidX.Room.extensions)

    // Dagger
    implementation(Dependencies.Dagger.dagger)
    kapt(Dependencies.Dagger.compiler)

    // Retrofit-OkHttp
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.moshi)
    implementation(Dependencies.OkHttp.okhttp)
    implementation(Dependencies.OkHttp.loggingInterceptor)
}