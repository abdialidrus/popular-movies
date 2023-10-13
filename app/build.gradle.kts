plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.abdialidrus.popularmovies"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.abdialidrus.popularmovies"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
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
}