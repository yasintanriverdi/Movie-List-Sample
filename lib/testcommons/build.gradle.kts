
plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.kotlinAndroid)
}

dependencies {

    implementation(Dependencies.Test.junit)
    implementation(Dependencies.Test.coroutines)
}