plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    google()
    mavenCentral()
}

dependencies {

    implementation(project(":common"))

    // Coroutines
    implementation(Dependencies.Coroutines.kotlinCoroutinesCore)

    // Javax inject
    implementation(Dependencies.Inject.inject)

    // Paging - Common
    implementation(Dependencies.Paging3.pagingCommon)
}