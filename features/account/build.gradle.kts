import extensions.accountModuleDeps
import extensions.androidTestDeps
import extensions.unitTestDeps

plugins {
    id(Plugins.ANDROID_DYNAMIC_FEATURE)
    kotlin(Plugins.ANDROID)
    kotlin(Plugins.KAPT)
    id(Plugins.DAGGER_HILT)
}

android {
    compileSdk = AndroidConfig.COMPILE_SDK

    defaultConfig {
        minSdk = AndroidConfig.MIN_SDK

        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
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

    buildFeatures {
        viewBinding = true
        // dataBinding = true
    }

    kapt {
        correctErrorTypes = true
    }
}

kapt {
    arguments {
        // Make Hilt share the same definition of Components in tests instead of
        // creating a new set of Components per test class.
        arg("dagger.hilt.shareTestComponents", "true")
    }
}

dependencies {
    // Required dependencies
    accountModuleDeps()

    // Unit Test
    unitTestDeps()

    // Android Test
    androidTestDeps()
}
