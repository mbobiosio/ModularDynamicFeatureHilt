pluginManagement {
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "androidx.navigation" -> {
                    useModule("androidx.navigation:navigation-safe-args-gradle-plugin:2.4.2")
                }
                "dagger.hilt.android.plugin" -> {
                    useModule("com.google.dagger:hilt-android-gradle-plugin:2.41")
                }
            }
        }
    }

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "ModularDynamicFeatureHilt"
include(
    ":app",
    ":common",
    ":data",
    ":domain",
    ":features:home",
    ":features:favorite",
    ":features:account"
)
