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
