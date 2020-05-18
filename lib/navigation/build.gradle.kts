plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.kotlinAndroid)
    id(Plugins.safeArgs)
}

dependencies {

    implementation(Dependencies.Kotlin.stdlib)

    // AndroidX
    implementation(Dependencies.AndroidX.Navigation.ui)
    implementation(Dependencies.AndroidX.Fragment.fragmentKtx)
}