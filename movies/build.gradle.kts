import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinKapt)
}

dependencies {

    implementation(Dependencies.Kotlin.stdlib)

    // AndroidX
    implementation(Dependencies.AndroidX.Fragment.fragment)
    implementation(Dependencies.AndroidX.Fragment.fragmentKtx)

    // Dagger
    implementation(Dependencies.Dagger.dagger)
    kapt(Dependencies.Dagger.compiler)
}