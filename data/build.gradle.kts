import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("io.objectbox")
    id("org.jlleitschuh.gradle.ktlint")
}

android {
    compileSdkVersion(Versions.compileSdkVersion)

    defaultConfig {
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        setTargetCompatibility(1.8)
        setSourceCompatibility(1.8)
    }
}

dependencies {
    api(Deps.reactiveX)
    api(Deps.networking)
    api(Deps.objectBox)
    api(Deps.javaInject)
    testImplementation(Deps.unitTest)
}

ktlint {
    version.set("0.31.0")
    ignoreFailures.set(true)
    reporters.set(setOf(ReporterType.CHECKSTYLE))
}
