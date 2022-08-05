plugins {
    id(Dependencies.Plugins.androidLibrary)
    kotlin("android")
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    api(project(":common"))

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

    // RecyclerView
    implementation(Dependencies.RecyclerView.recyclerveiw)

    // Glide
    implementation(Dependencies.Glide.glide)

    //Coil for Load Image
    implementation(Dependencies.Coil.coil)
    //For Svg Image
    implementation(Dependencies.Coil.coilSvg)

    // Palette
    implementation(Dependencies.Palette.palette)

    // Javax inject
    implementation(Dependencies.Inject.inject)
}