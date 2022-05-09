import extensions.androidTestDeps
import extensions.commonModuleDeps
import extensions.unitTestDeps

plugins {
    id(Plugins.ANDROID_LIBRARY)
    kotlin(Plugins.ANDROID)
}

android {
    compileSdk = AndroidConfig.COMPILE_SDK

    defaultConfig {
        minSdk = AndroidConfig.MIN_SDK

        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // Required dependencies
    commonModuleDeps()

    // Unit Test
    unitTestDeps()

    // Android Test
    androidTestDeps()
}
