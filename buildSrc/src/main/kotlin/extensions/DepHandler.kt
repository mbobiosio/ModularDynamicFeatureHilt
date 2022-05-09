package extensions

import Deps
import Modules
import TestDeps
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler

/*
* Adds required dependencies to app module
* */
fun DependencyHandler.appModuleDeps() {
    // Libraries
    implementation(project(Modules.common))
    implementation(project(Modules.data))
    implementation(project(Modules.domain))

    // Navigation Component
    implementation(Deps.AndroidX.Navigation.ui)
    implementation(Deps.AndroidX.Navigation.fragment)
    implementation(Deps.AndroidX.Navigation.dynamicFeaturesFragment)

    api(Deps.Android.material)
    api(Deps.AndroidX.appcompat)
    api(Deps.AndroidX.Constraint.constraintLayout)

    // Hilt
    implementation(Deps.Dagger.hiltAndroid)
    kapt(Deps.Dagger.hiltAndroidCompiler)
}

/*
* Adds required dependencies to home module
* */
fun DependencyHandler.homeModuleDeps() {

    // Libraries
    implementation(project(Modules.common))
    implementation(project(Modules.app))
    implementation(project(Modules.data))
    implementation(project(Modules.domain))

    // Navigation components
    implementation(Deps.AndroidX.Navigation.fragment)

    // Hilt
    implementation(Deps.Dagger.hiltAndroid)
    kapt(Deps.Dagger.hiltAndroidCompiler)
}

/*
* Add required dependencies to favorite module
* */
fun DependencyHandler.favoriteModuleDeps() {
    // Libraries
    implementation(project(Modules.common))
    implementation(project(Modules.app))
    implementation(project(Modules.data))
    implementation(project(Modules.domain))

    // Navigation components
    implementation(Deps.AndroidX.Navigation.fragment)

    // Hilt
    implementation(Deps.Dagger.hiltAndroid)
    kapt(Deps.Dagger.hiltAndroidCompiler)
}

/*
* Add required dependencies to account module
* */
fun DependencyHandler.accountModuleDeps() {
    // Libraries
    implementation(project(Modules.common))
    implementation(project(Modules.app))
    implementation(project(Modules.data))
    implementation(project(Modules.domain))

    // AndroidX
    api(Deps.Android.material)
    api(Deps.AndroidX.appcompat)
    api(Deps.AndroidX.Constraint.constraintLayout)

    // Hilt
    implementation(Deps.Dagger.hiltAndroid)
    kapt(Deps.Dagger.hiltAndroidCompiler)
}

/*
* Add required dependencies to common module
* */
fun DependencyHandler.commonModuleDeps() {
    // KTX
    api(Deps.AndroidX.coreKtx)
    implementation(Deps.AndroidX.Fragment.fragmentKtx)
    implementation(Deps.AndroidX.Activity.activityKtx)
    implementation(Deps.AndroidX.Navigation.commonKtx)

    // Coroutines
    api(Deps.Coroutines.core)
    api(Deps.Coroutines.android)

    // AndroidX Libs
    api(Deps.Android.material)
    api(Deps.AndroidX.appcompat)
    api(Deps.AndroidX.Constraint.constraintLayout)

    // Timber
    api(Deps.Timber.timber)
}

/*
* Add required dependencies to data module
* */
fun DependencyHandler.dataModuleDeps() {
    implementation(project(Modules.common))
    implementation(project(Modules.domain))
}

/*
* Add required dependencies to domain module
* */
fun DependencyHandler.domainModuleDeps() {
    implementation(project(Modules.common))
}

/*
* Add Unit test dependencies
* */
fun DependencyHandler.unitTestDeps() {
    // (Required) writing and executing Unit Tests on the JUnit Platform
    testImplementation(TestDeps.JUnit.junit)

    // AndroidX Test - JVM testing
    testImplementation(TestDeps.AndroidX.coreKtx)

    // Coroutines Test
    testImplementation(TestDeps.Coroutines.coroutines)

    // MockWebServer
    testImplementation(TestDeps.MockWebServer.mockwebserver)

    // MocKK
    testImplementation(TestDeps.MockK.mockK)

    // Truth
    testImplementation(TestDeps.truth)
}

/*
* Add Instrumentation test dependencies
* */
fun DependencyHandler.androidTestDeps() {
    // AndroidX Test - Instrumented testing
    androidTestImplementation(TestDeps.AndroidX.androidX_jUnit)
    androidTestImplementation(TestDeps.AndroidX.coreTesting)

    // Espresso
    androidTestImplementation(TestDeps.espressoCore)

    // Navigation Testing
    androidTestImplementation(TestDeps.AndroidX.navigationTest)

    // Coroutines Test
    androidTestImplementation(TestDeps.Coroutines.coroutines)

    // MockWebServer
    androidTestImplementation(TestDeps.MockWebServer.mockwebserver)

    // MockK
    androidTestImplementation(TestDeps.MockK.mockK)

    // Truth
    androidTestImplementation(TestDeps.truth)
}

/*
 * These extensions mimic the extensions that are generated on the fly by Gradle.
 * They are used here to provide above dependency syntax that mimics Gradle Kotlin DSL
 * syntax in module\build.gradle.kts files.
 */
@Suppress("detekt.UnusedPrivateMember")
private fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

@Suppress("detekt.UnusedPrivateMember")
private fun DependencyHandler.api(dependencyNotation: Any): Dependency? =
    add("api", dependencyNotation)

@Suppress("detekt.UnusedPrivateMember")
private fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

private fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

private fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)

private fun DependencyHandler.testRuntimeOnly(dependencyNotation: Any): Dependency? =
    add("testRuntimeOnly", dependencyNotation)

private fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

private fun DependencyHandler.project(
    path: String,
    configuration: String? = null
): ProjectDependency {
    val notation = if (configuration != null) {
        mapOf("path" to path, "configuration" to configuration)
    } else {
        mapOf("path" to path)
    }

    return uncheckedCast(project(notation))
}

@Suppress("unchecked_cast", "nothing_to_inline", "detekt.UnsafeCast")
private inline fun <T> uncheckedCast(obj: Any?): T = obj as T
