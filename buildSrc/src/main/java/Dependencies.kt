object Version {
    const val core = "1.9.0"
    const val lifecycleRuntime = "2.6.2"
    const val composeActivity = "1.7.2"
    const val composeBom = "2023.03.00"
    const val composeBomAndroidTestImpl = "2023.03.00"
    const val junit = "4.13.2"
    const val junitAndroid = "1.1.5"
    const val espressoCore = "3.5.1"
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