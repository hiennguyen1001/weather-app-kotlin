// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        maven {
            url = uri("https://maven.google.com/")
            name = "Google"
        }
        jcenter()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }

    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.3.2")
        classpath(kotlin("gradle-plugin", version = Versions.kotlin_version))
        classpath("io.objectbox:objectbox-gradle-plugin:${Versions.objectboxVersion}")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:7.2.1")
        classpath("com.android.tools.build.jetifier:jetifier-processor:1.0.0-beta04")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}
gradle.projectsEvaluated {
    tasks.withType(JavaCompile::class) {
        options.compilerArgs = kotlin.collections.arrayListOf("-Xmaxerrs", "500")
    }
}
