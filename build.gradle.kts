buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Libs.androidGradlePlugin)
        classpath(Libs.Kotlin.gradlePlugin)
        classpath(Libs.Dagger.hiltGradlePlugin)
        classpath(Libs.AndroidX.Navigation.navigationSafeArguments)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")

    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}