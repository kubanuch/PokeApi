plugins {
    id(Dependencies.Plugins.androidLibrary)
    kotlin("android")
    kotlin(Dependencies.Plugins.kapt)
}
repositories {
    google()
    mavenCentral()
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
}

dependencies {

    implementation(project(":core"))

    implementation(project(":domain"))

    // Android core
    implementation(Dependencies.AndroidCore.core)

    // AppCompat
    implementation(Dependencies.AppCompat.appCompat)

    // Material Design
    implementation(Dependencies.MaterialDesign.material)

    // Constraint layout
    implementation(Dependencies.AndroidCore.constraint)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    // Unit test
    testImplementation(Dependencies.Tests.unitTest)

    // JUnit test
    androidTestImplementation(Dependencies.Tests.jUnit)

    // Espresso test
    androidTestImplementation(Dependencies.Tests.espresso)

    // Kotlin Coroutines
    implementation(Dependencies.Coroutines.kotlinCoroutines)

    // Dagger Hilt
    implementation(Dependencies.Hilt.hiltAndroid)

    // Retrofit 2
    implementation(Dependencies.Retrofit.retrofit)

    // Gson
    implementation(Dependencies.Gson.gson)

    // Paging 3
    implementation(Dependencies.Paging3.pagingRuntime)
    testImplementation(Dependencies.Paging3.pagingCommon)

    // Room
    implementation(Dependencies.Room.room)
    implementation(Dependencies.Room.roomRuntime)
    kapt(Dependencies.Room.roomCompiler)
    implementation(Dependencies.Room.roomPaging)
}