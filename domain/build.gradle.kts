plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.jetbrains.kotlin.android)

}

android {
    compileSdk = 34
    namespace = "com.mohammedalaa.domain"

    defaultConfig {
        minSdk  =24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    libs.apply {
        implementation(javax.inject)
        implementation(hilt.android)
        "ksp" (libs.hilt.android.compiler)
    }
}