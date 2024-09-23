pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("com.android.application") version "8.1.2"
    }
}

rootProject.name = "cis3515-assignment-2"
include(":app")
