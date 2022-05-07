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
    // KTX
    api(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.Fragment.fragmentKtx)
    implementation(Libs.AndroidX.Activity.activityKtx)
    implementation(Libs.AndroidX.Navigation.commonKtx)

    // Coroutines
    api(Libs.Coroutines.core)
    api(Libs.Coroutines.android)

    // Common Libs
    api(Libs.Android.material)
    api(Libs.AndroidX.appcompat)
    api(Libs.AndroidX.Constraint.constraintLayout)

    // Timber
    api(Libs.Timber.timber)

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