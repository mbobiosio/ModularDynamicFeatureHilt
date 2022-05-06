object Versions {
    const val ktlint = "0.43.0"
}

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.1.3"
    const val secretsGradlePlugin =
        "com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.0"

    object Kotlin {
        private const val version = "1.6.21"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
    }

    object Coroutines {
        private const val version = "1.6.1"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object Android {
        const val material = "com.google.android.material:material:1.7.0-alpha01"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.4.1"
        const val palette = "androidx.palette:palette:1.0.0"
        const val coreKtx = "androidx.core:core-ktx:1.7.0"

        object Activity {
            const val version = "1.4.0"
            const val activityCompose = "androidx.activity:activity-compose:1.4.0"
            const val activityKtx = "androidx.activity:activity-ktx:$version"
        }

        object Fragment {
            const val version = "1.4.1"
            const val fragmentKtx = "androidx.fragment:fragment-ktx:$version"
            const val fragmentTesting = "androidx.fragment:fragment-testing:$version"
        }

        object Constraint {
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.3"
            const val constraintLayoutCompose =
                "androidx.constraintlayout:constraintlayout-compose:1.0.0-rc02"
        }

        object Compose {
            const val version = "1.1.0-rc02"
            const val composeVersion = "1.0.5"

            const val runtime = "androidx.compose.runtime:runtime:$composeVersion"
            const val foundation = "androidx.compose.foundation:foundation:$composeVersion"
            const val layout = "androidx.compose.foundation:foundation-layout:$composeVersion"

            const val ui = "androidx.compose.ui:ui:$composeVersion"
            const val material = "androidx.compose.material:material:$composeVersion"
            const val materialIconsExtended =
                "androidx.compose.material:material-icons-extended:$composeVersion"

            const val tooling = "androidx.compose.ui:ui-tooling:$composeVersion"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:$composeVersion"
        }

        object Lifecycle {
            private const val version = "2.4.0"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
        }

        object Navigation {
            private const val version = "2.4.2"
            const val navigationSafeArguments =
                "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
            const val compose = "androidx.navigation:navigation-compose:$version"

            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val commonKtx = "androidx.navigation:navigation-common-ktx:$version"
            const val dynamicFeaturesFragment =
                "androidx.navigation:navigation-dynamic-features-fragment:$version"
            const val testing = "androidx.navigation:navigation-testing:$version"
        }

        object Work {
            private const val version = "2.7.1"
            const val runtime = "androidx.work:work-runtime:$version"
        }

        object Test {
            private const val version = "1.4.0"
            const val core = "androidx.test:core:$version"
            const val rules = "androidx.test:rules:$version"
            const val coreTesting = "androidx.arch.core:core-testing:2.1.0"

            object Ext {
                private const val version = "1.1.3"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }

            const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
        }

        object Room {
            private const val version = "2.4.0"
            const val runtime = "androidx.room:room-runtime:$version"
            const val ktx = "androidx.room:room-ktx:$version"
            const val compiler = "androidx.room:room-compiler:$version"
        }

        object SQLiteKtx {
            private const val version = "2.2.0"
            const val sqliteKtx = "androidx.sqlite:sqlite-ktx:$version"
        }
    }

    object Dagger {
        private const val version = "2.41"
        const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val hiltAndroid = "com.google.dagger:hilt-android:$version"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-compiler:$version"
        const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:$version"
        //const val hiltCompiler = "androidx.hilt:hilt-compiler:$version"
    }

    object OkHttp {
        private const val version = "4.9.1"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val logging = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object Coil {
        private const val version = "1.4.0"
        const val coilCompose = "io.coil-kt:coil-compose:$version"
    }

    object Timber {
        private const val version = "5.0.1"
        const val timber = "com.jakewharton.timber:timber:$version"
    }

    object Glide {
        private const val version = "4.12.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
    }

    object Shimmer {
        private const val version = "0.5.0"
        const val shimmer = "com.facebook.shimmer:shimmer:$version"
    }

    object LeakCanary {
        private const val version = "2.6"
        const val leakcanary = "com.squareup.leakcanary:leakcanary-android:$version"
    }

    object SqlCipher {
        private const val version = "4.4.0"
        const val sqlcipher = "net.zetetic:android-database-sqlcipher:$version"
    }

    object JUnit {
        private const val version = "4.13.2"
        const val junit = "junit:junit:$version"
    }

    object MockWebServer {
        private const val version = "4.9.3"
        const val mockwebserver = "com.squareup.okhttp3:mockwebserver:$version"
        const val okhttpIdlingResource = "com.jakewharton.espresso:okhttp3-idling-resource:1.0.0"
    }

    object Mockito {
        private const val version = "4.3.0"
        const val core = "org.mockito:mockito-core:$version"
        const val inline = "org.mockito:mockito-inline:$version"
        const val android = "org.mockito:mockito-android:$version"
    }

    object RoboElectric {
        private const val version = "4.6"
        const val robolectric = "org.robolectric:robolectric:$version"
    }

    object Turbine {
        private const val version = "0.7.0"
        const val turbine = "app.cash.turbine:turbine:$version"
    }

    object Lottie {
        private const val version = "3.6.1"
        const val lottie = "com.airbnb.android:lottie:$version"
    }

    object PrettyTime {
        private const val version = "4.0.4.Final"
        const val prettyTime = "org.ocpsoft.prettytime:prettytime:$version"
    }

    object JodaTime {
        private const val version = "2.10.13"
        const val jodaTime = "joda-time:joda-time:$version"
    }
}