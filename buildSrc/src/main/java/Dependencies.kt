object Dependencies {

    object AndroidCore {
        const val core = "androidx.core:core-ktx:1.7.0"
        const val constraint = "androidx.constraintlayout:constraintlayout:2.1.4"
    }

    object MaterialDesign {
        private const val version = "1.6.1"

        const val material = "com.google.android.material:material:$version"
    }

    object AppCompat {
        private const val version = "1.4.2"

        const val appCompat = "androidx.appcompat:appcompat:$version"
    }

    object Tests {
        const val unitTest = "junit:junit:4.13.2"
        const val jUnit = "androidx.test.ext:junit:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
    }

    object Coroutines {
        private const val version = "1.5.2"
        const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val kotlinCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
    }

    object NavigationComponents {
        private const val version = "2.3.5"

        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$version"
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
    }

    object Gson {
        private const val version = "2.9.0"

        const val gson = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp {
        const val bom = "com.squareup.okhttp3:okhttp-bom:4.9.0"
        const val okhttp = "com.squareup.okhttp3:okhttp"
        const val interceptor = "com.squareup.okhttp3:logging-interceptor"
    }

    object ViewBindingPropertyDelegate {
        private const val version = "1.5.3"
        const val bindingNoReflection =
            "com.github.kirich1409:viewbindingpropertydelegate-noreflection:$version"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:4.12.0"
    }

    object Activity {
        const val version = "androidx.activity:activity-ktx:1.4.0"
    }

    object Fragment {
        const val version = "androidx.fragment:fragment-ktx:1.4.1"
    }

    object Lifecycles {
        private const val version = "2.4.0"

        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
    }

    object Plugins {

        const val applicationVersion = "7.1.3"
        const val application = "com.android.application"

        const val androidLibraryVersion = "7.1.3"
        const val androidLibrary = "com.android.library"

        const val kotlinVersion = "1.6.21"
        const val kotlin = "org.jetbrains.kotlin.android"

        const val kapt = "kapt"

        const val hilt = "dagger.hilt.android.plugin"

        const val safeArgs = "androidx.navigation.safeargs.kotlin"
    }

    object Hilt {

        private const val version = "2.38.1"

        const val hiltAndroid = "com.google.dagger:hilt-android:$version"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:$version"
    }

    object Coil {

        private const val version = "1.3.2"

        const val coil = "io.coil-kt:coil:$version"
        const val coilSvg = "io.coil-kt:coil-svg:$version"
    }

    object RecyclerView {
        const val recyclerveiw = "androidx.recyclerview:recyclerview:1.2.1"
    }

    object Inject {
        const val inject = "javax.inject:javax.inject:1"
    }

    object Paging3 {
        private const val version = "3.1.1"

        const val pagingRuntime = "androidx.paging:paging-runtime-ktx:$version"
        const val pagingCommon = "androidx.paging:paging-common-ktx:$version"
    }

    object Room {
        private const val version = "2.4.2"

        const val roomRuntime = "androidx.room:room-runtime:$version"
        const val roomCompiler = "androidx.room:room-compiler:$version"
        const val room = "androidx.room:room-ktx:$version"
        const val roomPaging = "androidx.room:room-paging:$version"
    }

    object Palette {
        const val palette = "androidx.palette:palette:1.0.0"
    }
}