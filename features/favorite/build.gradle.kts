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
        //dataBinding = true
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
    implementation(project(Modules.common))
    implementation(project(Modules.app))
    implementation(project(Modules.data))
    implementation(project(Modules.domain))

    // Navigation Component
    implementation(Libs.AndroidX.Navigation.fragment)

    // Hilt
    implementation(Libs.Dagger.hiltAndroid)
    kapt(Libs.Dagger.hiltAndroidCompiler)

    // Unit Test
    testImplementation(Libs.JUnit.junit)
    testImplementation(Libs.AndroidX.Test.coreTesting)
    testImplementation(Libs.Turbine.turbine)
    testImplementation(Libs.Coroutines.test)
    testImplementation(Libs.MockWebServer.mockwebserver)

    // Android Test
    androidTestImplementation(Libs.Turbine.turbine)
    androidTestImplementation(Libs.AndroidX.Test.core)
    androidTestImplementation(Libs.AndroidX.Test.rules)
    androidTestImplementation(Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation(Libs.AndroidX.Test.espressoCore)
    androidTestImplementation(Libs.MockWebServer.mockwebserver)
    androidTestImplementation(Libs.MockWebServer.okhttpIdlingResource)
}