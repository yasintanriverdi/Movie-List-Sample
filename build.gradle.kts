import com.android.build.gradle.BaseExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(Plugins.spotless) version Versions.spotless
}

buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(Classpaths.gradle)
        classpath(Classpaths.kotlinGradle)
        classpath(Classpaths.safeArgs)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

subprojects {

    project.pluginManager.apply(Plugins.spotless)

    spotless {
        java {
            // This is required otherwise the code in android modules isn"t picked up by spotless.
            target("**/*.java")
            trimTrailingWhitespace()
            removeUnusedImports()
            googleJavaFormat()
        }

        kotlin {
            target("**/*.kt")
            ktlint("0.29.0").userData(hashMapOf("indent_size" to "4", "android" to "true", "max_line_length" to "200"))
        }

        kotlinGradle {
            target("**/*.gradle.kts")
            ktlint("0.29.0").userData(hashMapOf("indent_size" to "4", "android" to "true", "max_line_length" to "200"))
        }

        format("misc") {
            target("**/.gitignore", "**/*.gradle", "**/*.md", "**/*.sh", "**/*.yml")
            trimTrailingWhitespace()
            endWithNewline()
        }
    }

    project.tasks.withType(KotlinCompile::class.java) {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict", "-progressive")
            jvmTarget = "1.8"
        }
    }

    project.plugins.whenPluginAdded {
        when (this) {
            is AppPlugin, is LibraryPlugin -> {
                the<BaseExtension>().apply {
                    compileSdkVersion(Configs.Versions.compileSdk)

                    defaultConfig {
                        minSdkVersion(Configs.Versions.minSdk)
                        targetSdkVersion(Configs.Versions.targetSdk)
                    }

                    compileOptions {
                        targetCompatibility = JavaVersion.VERSION_1_8
                        sourceCompatibility = JavaVersion.VERSION_1_8
                    }

                    sourceSets{
                        getByName("main") {
                            java.srcDir("src/main/kotlin")
                        }
                        getByName("test") {
                            java.srcDir("src/test/kotlin")
                        }
                        getByName("androidTest") {
                            java.srcDir("src/androidTest/kotlin")
                        }
                    }
                }
            }

            is JavaPlugin -> {
                the<JavaPluginConvention>().apply {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }
            }
        }
    }
}