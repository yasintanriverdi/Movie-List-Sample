object Dependencies {
    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:${Versions.kotlin}"

        object Coroutines {
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
            const val android =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        }
    }

    object Google {
        const val material = "com.google.android.material:material:${Versions.material}"
    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"

        object Navigation {
            const val fragment =
                "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
            const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        }

        object Fragment {
            const val fragment = "androidx.fragment:fragment:${Versions.fragment}"
            const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
        }

        object Lifecycle {
            const val extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
            const val viewmodelKtx =
                "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        }

        object Paging {
            const val core = "androidx.paging:paging-runtime-ktx:${Versions.paging}"
            const val common = "androidx.paging:paging-common-ktx:${Versions.paging}"
        }

        object Room {
            const val core = "androidx.room:room-runtime:${Versions.room}"
            const val compiler = "androidx.room:room-compiler:${Versions.room}"
            const val extensions = "androidx.room:room-ktx:${Versions.room}"
        }

        const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"

    }

    object Dagger {
        const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
        const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    }

    object OkHttp {
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    }

    object Glide {
        const val core = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }

    object Test {
        const val archCore = "androidx.arch.core:core-testing:${Versions.archCore}"
        const val core = "androidx.test:core:${Versions.test}"
        const val runner = "androidx.test:runner:${Versions.test}"
        const val rules = "androidx.test:rules:${Versions.test}"

        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"

        const val mockk = "io.mockk:mockk:${Versions.mockk}"

        const val junit = "junit:junit:${Versions.junit}"

        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okHttp}"
    }
}