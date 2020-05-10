import Configs.Versions.versionMajor
import Configs.Versions.versionMinor
import Configs.Versions.versionPatch

object Configs {
    const val applicationId = "com.yasintanriverdi.movielistsample"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    object Versions {
        const val compileSdk = 29
        const val minSdk = 21
        const val targetSdk = 29

        internal const val versionMajor = 0
        internal const val versionMinor = 0
        internal const val versionPatch = 1
    }

    val versionCode
        get() = versionMajor * 1000000 + versionMinor * 10000 + versionPatch * 100

    val versionName
        get() = "${versionMajor}.${versionMinor}.${versionPatch}"
}