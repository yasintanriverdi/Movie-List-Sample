import com.android.build.gradle.BaseExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryPlugin

buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(Classpaths.gradle)
        classpath(Classpaths.kotlinGradle)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

subprojects {
    project.plugins.whenPluginAdded {
        when (this) {
            is AppPlugin, is LibraryPlugin -> {
                the<BaseExtension>().apply {
                    compileSdkVersion(Configs.Versions.compileSdk)

                    defaultConfig {
                        minSdkVersion(Configs.Versions.minSdk)
                        targetSdkVersion(Configs.Versions.targetSdk)
                    }
                }
            }
        }
    }
}

task("clean") {
    delete { rootProject.buildDir }
}