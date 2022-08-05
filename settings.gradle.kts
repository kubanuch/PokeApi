pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:7.0.0")
            }
            if (requested.id.id.startsWith("org.jetbrains.kotlin")) {
                useVersion("1.6.21")
            }
            if (requested.id.id == "dagger.hilt.android.plugin") {
                useModule("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
            }
            if (requested.id.id == "androidx.navigation.safeargs.kotlin") {
                useModule("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.5")
            }
        }
    }
}
rootProject.name = "PokeApi"
include(":app")
include(":core")
include(":common")
include(":data")
include(":domain")
