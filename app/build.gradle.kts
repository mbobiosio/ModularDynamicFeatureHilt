plugins {
    id(Plugins.ANDROID_APPLICATION)
    kotlin(Plugins.ANDROID)
    kotlin(Plugins.KAPT)
    id(Plugins.DAGGER_HILT)
    id(Plugins.NAVIGATION_SAFE_ARGS)
}

android {
    compileSdk = AndroidConfig.COMPILE_SDK

    defaultConfig {
        applicationId = AndroidConfig.APPLICATION_ID
        minSdk = AndroidConfig.MIN_SDK
        targetSdk = AndroidConfig.TARGET_SDK
        /*
        Retaining versionCode to a fixed number to avoid breaking instant run.
        */
        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME

        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
        vectorDrawables.useSupportLibrary = true
        setProperty("archivesBaseName", "$applicationId-v$versionName(${AndroidConfig.versionBuild})")
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

    buildFeatures {
        viewBinding = true
    }

    dynamicFeatures.apply {
        add(DynamicFeature.home)
        add(DynamicFeature.favorite)
        add(DynamicFeature.account)
    }

    sourceSets {
        getByName("main").java.srcDir("src/main/kotlin")
        getByName("test").java.srcDir("src/test/kotlin")
        getByName("androidTest").java.srcDir("src/androidTest/kotlin")
    }

    applicationVariants.all {
        outputs.all {
            val outputImpl = this as com.android.build.gradle.internal.api.ApkVariantOutputImpl
            if (!buildType.isDebuggable)
                outputImpl.versionCodeOverride = AndroidConfig.versionBuild
        }
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
    implementation(project(Modules.data))
    implementation(project(Modules.domain))

    // Navigation Component
    implementation(Libs.AndroidX.Navigation.ui)
    implementation(Libs.AndroidX.Navigation.fragment)
    implementation(Libs.AndroidX.Navigation.dynamicFeaturesFragment)
    androidTestImplementation(Libs.AndroidX.Navigation.testing)

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