plugins {
    id(Dependencies.Plugins.application)
    kotlin("android")
    id("org.jetbrains.kotlin.plugin.parcelize")
    kotlin(Dependencies.Plugins.kapt)
    id(Dependencies.Plugins.hilt)
    id(Dependencies.Plugins.safeArgs)
}

repositories {
    google()
    mavenCentral()
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        debug {
            buildConfigField("String", "BASE_URL", "\"https://pokeapi.co/api/v2/\"")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
            buildConfigField("String", "BASE_URL", "\"https://pokeapi.co/api/v2/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":core"))

    implementation(project(":domain"))

    implementation(project(":data"))

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

    // Navigation Components
    implementation(Dependencies.NavigationComponents.navigationFragment)
    implementation(Dependencies.NavigationComponents.navigationUI)

    // Retrofit 2
    implementation(Dependencies.Retrofit.retrofit)

    // Gson
    implementation(Dependencies.Gson.gson)

    // OkHttp
    implementation(platform(Dependencies.OkHttp.bom))

    // define any required OkHttp artifacts without version
    implementation(Dependencies.OkHttp.okhttp)
    implementation(Dependencies.OkHttp.interceptor)

    // ViewBindingPropertyDelegate
    // To use only without reflection variants of viewBinding
    implementation(Dependencies.ViewBindingPropertyDelegate.bindingNoReflection)

    // Glide
    implementation(Dependencies.Glide.glide)

    // Activity version
    implementation(Dependencies.Activity.version)

    // Fragment version
    implementation(Dependencies.Fragment.version)

    // Lifecycle
    // | for ViewModel
    implementation(Dependencies.Lifecycles.lifecycleViewModel)
    // | for LiveData
    implementation(Dependencies.Lifecycles.lifecycleLiveData)

    // Lifecycles only (without ViewModel or LiveData)
    implementation(Dependencies.Lifecycles.lifecycle)

    // Dagger Hilt
    implementation(Dependencies.Hilt.hiltAndroid)
    kapt(Dependencies.Hilt.hiltCompiler)
    implementation(kotlin("reflect"))

    //Coil for Load Image
    implementation(Dependencies.Coil.coil)
    //For Svg Image
    implementation(Dependencies.Coil.coilSvg)

    // Paging 3
    implementation(Dependencies.Paging3.pagingRuntime)
    testImplementation(Dependencies.Paging3.pagingCommon)

    // Room
    implementation(Dependencies.Room.room)
    implementation(Dependencies.Room.roomRuntime)
    kapt(Dependencies.Room.roomCompiler)

    // Palette
    implementation(Dependencies.Palette.palette)
}