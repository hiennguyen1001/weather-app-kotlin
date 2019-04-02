import org.jetbrains.kotlin.gradle.internal.AndroidExtensionsExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("io.objectbox")
    id("org.jlleitschuh.gradle.ktlint")
}

android {
    compileSdkVersion(Versions.compileSdkVersion)

    defaultConfig {
        signingConfigs {
            create("weatherApp") {
                storeFile = project.file("../keystores/weatherApp")
                storePassword = "weather_app_2018"
                keyAlias = "WeatherApp"
                keyPassword = "weather_app_2018"
            }
        }

        applicationId = Configs.appId
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
        versionCode = Configs.versionCode
        versionName = Configs.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true

        buildConfigField("String", "BASE_ENDPOINT", "\"https://api.openweathermap.org/data/2.5/\"")
        resValue("string", "geo_api_key", "\"AIzaSyClwo50v8sJJyqk51jtV9uuEJrZ3P70iYE\"")

        externalNativeBuild {
            cmake {
                arguments.add("-DANDROID_TOOLCHAIN=clang")
            }
        }
    }

    dexOptions {
        maxProcessCount = 2
        javaMaxHeapSize = "4g"
        preDexLibraries = false
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("weatherApp")
        }
    }

    androidExtensions {
        // Workaround to get experimental features in Kotlin DSL
        // https://youtrack.jetbrains.com/issue/KT-22213
        configure(delegateClosureOf<AndroidExtensionsExtension> {
            isExperimental = true
        })
    }

    compileOptions {
        setTargetCompatibility(1.8)
        setSourceCompatibility(1.8)
    }

    dataBinding.isEnabled = true

    externalNativeBuild {
        cmake {
            setPath("src/main/jni/CMakeLists.txt")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(Deps.supportDeps)
    implementation(Deps.archDeps)
    implementation(Deps.otherLibs)
    implementation(Deps.dagger)

    debugImplementation(Deps.onlyDebug)
    releaseImplementation(Deps.onlyRelease)

    kapt(Deps.annotationProccessor)

    testImplementation(Deps.unitTest)
    androidTestImplementation(Deps.androidTest)
}

ktlint {
    version.set("0.31.0")
    ignoreFailures.set(true)
    reporters.set(setOf(ReporterType.CHECKSTYLE))
}
