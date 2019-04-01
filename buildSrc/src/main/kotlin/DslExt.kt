import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.kapt(dependencyArray: Array<String>) =
    dependencyArray.forEach {
        add("kapt", it)
    }

fun DependencyHandler.implementation(dependencyArray: Array<String>) =
    dependencyArray.forEach {
        add("implementation", it)
    }

fun DependencyHandler.debugImplementation(dependencyArray: Array<String>) =
    dependencyArray.forEach {
        add("debugImplementation", it)
    }

fun DependencyHandler.releaseImplementation(dependencyArray: Array<String>) =
    dependencyArray.forEach {
        add("releaseImplementation", it)
    }

fun DependencyHandler.testImplementation(dependencyArray: Array<String>) =
    dependencyArray.forEach {
        add("testImplementation", it)
    }

fun DependencyHandler.androidTestImplementation(dependencyArray: Array<String>) =
    dependencyArray.forEach {
        add("androidTestImplementation", it)
    }

fun DependencyHandler.api(dependencyArray: Array<String>) =
    dependencyArray.forEach {
        add("api", it)
    }