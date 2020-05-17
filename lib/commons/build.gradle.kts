plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinKapt)
}

android {
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(Dependencies.Kotlin.stdlib)

    // AndroidX
    implementation(Dependencies.AndroidX.Fragment.fragmentKtx)
    implementation(Dependencies.AndroidX.Lifecycle.extensions)
    implementation(Dependencies.AndroidX.Lifecycle.viewmodelKtx)
    implementation(Dependencies.AndroidX.recyclerView)

    implementation(Dependencies.Google.material)

    // Glide
    implementation(Dependencies.Glide.core)
    kapt(Dependencies.Glide.compiler)
}