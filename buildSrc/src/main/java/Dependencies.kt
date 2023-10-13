object Version {
    const val core = "1.9.0"
    const val lifecycleRuntime = "2.6.2"
    const val composeActivity = "1.7.2"
    const val composeBom = "2023.03.00"
    const val composeBomAndroidTestImpl = "2023.03.00"
    const val junit = "4.13.2"
    const val junitAndroid = "1.1.5"
    const val espressoCore = "3.5.1"
    const val retrofit = "2.9.0"
    const val okhttp3Bom = "4.9.1"
    const val room = "2.5.2"
    const val hiltAndroid = "2.47"
    const val hiltCompiler = "1.0.0"
    const val hiltLifecycleViewModel = "1.0.0-alpha03"
    const val hiltAndroidCompiler = "2.44"
}

object Deps {
    const val core = "androidx.core:core-ktx:${Version.core}"
}

object CoroutineLifecycleScope {
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycleRuntime}"
}

object JetpackCompose {
    const val composeActivity = "androidx.activity:activity-compose:${Version.composeActivity}"
    const val composeBom = "androidx.compose:compose-bom:${Version.composeBom}"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
    const val composeMaterial3 = "androidx.compose.material3:material3"
}

object JetpackComposeAndroidTestImplementation {
    const val composeBom = "androidx.compose:compose-bom:${Version.composeBomAndroidTestImpl}"
    const val composeUiTest = "androidx.compose.ui:ui-test-junit4"
}

object JetpackComposeDebugImplementation {
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
}

object TestImplementation {
    const val junit = "junit:junit:${Version.junit}"
}

object AndroidTestImplementation {
    const val junit = "androidx.test.ext:junit:${Version.junitAndroid}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espressoCore}"
}

object Retrofit2 {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
}

object OkHttp3 {
    const val okhttp3Bom = "com.squareup.okhttp3:okhttp-bom:${Version.okhttp3Bom}"
    const val okhttp3Okhttp = "com.squareup.okhttp3:okhttp"
    const val okhttp3LoggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
}

object Room {
    const val roomRuntime = "androidx.room:room-runtime:${Version.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.room}"
}

object Hilt {
    const val hiltAndroid = "com.google.dagger:hilt-android:${Version.hiltAndroid}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Version.hiltAndroidCompiler}"
    const val hiltLifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Version.hiltLifecycleViewModel}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Version.hiltCompiler}"
}