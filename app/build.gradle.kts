plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")

}

android {
    namespace = "com.abdialidrus.popularmovies"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.abdialidrus.popularmovies"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Deps.core)
    implementation(CoroutineLifecycleScope.lifecycleRuntime)
    implementation(JetpackCompose.composeActivity)
    implementation(platform(JetpackCompose.composeBom))
    implementation(JetpackCompose.composeUi)
    implementation(JetpackCompose.composeUiGraphics)
    implementation(JetpackCompose.composeMaterial3)

    testImplementation(TestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.espresso)

    androidTestImplementation(platform(JetpackComposeAndroidTestImplementation.composeBom))
    androidTestImplementation(JetpackComposeAndroidTestImplementation.composeUiTest)
    debugImplementation(JetpackComposeDebugImplementation.composeUiTooling)
    debugImplementation(JetpackComposeDebugImplementation.composeUiTestManifest)

    implementation(Retrofit2.retrofit)
    implementation(Retrofit2.converterGson)
    implementation(OkHttp3.okhttp3Bom)
    implementation(OkHttp3.okhttp3Okhttp)
    implementation(OkHttp3.okhttp3LoggingInterceptor)

    implementation(Room.roomRuntime)
    kapt(Room.roomCompiler)
    implementation(Room.roomKtx)

    implementation(Hilt.hiltAndroid)
    kapt(Hilt.hiltAndroidCompiler)
    //implementation(Hilt.hiltLifecycleViewModel)
    kapt(Hilt.hiltCompiler)

    implementation("androidx.navigation:navigation-compose:2.7.4")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")
    implementation("io.coil-kt:coil-compose:2.4.0")

    implementation("androidx.paging:paging-runtime:3.1.1")
    implementation("androidx.paging:paging-compose:3.2.0-rc01")
}

kapt {
    correctErrorTypes = true
}