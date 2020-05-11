plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinKapt)
}

dependencies {

    implementation(Dependencies.Kotlin.stdlib)

    implementation(Dependencies.AndroidX.Fragment.fragmentKtx)
    implementation(Dependencies.AndroidX.Lifecycle.extensions)
    implementation(Dependencies.AndroidX.Lifecycle.viewmodelKtx)
}