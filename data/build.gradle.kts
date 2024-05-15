plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    compileSdk = 34
    namespace = "com.mohammedalaa.data"
}

dependencies {

    api(project(":domain"))
    implementation(libs.hilt.android)
    implementation(libs.retrofit)
    implementation(libs.logging.interceptor)
    implementation(libs.kotlinx.serialization.converter)
    implementation(libs.kotlinx.serialization.json)
    "ksp" (libs.hilt.android.compiler)
}