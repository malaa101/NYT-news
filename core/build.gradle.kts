plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.mohammedalaa.core"
    compileSdk = 34
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    api(project(":domain"))
    implementation(project(":designsystem"))
    implementation(libs.hilt.android)
    "ksp" (libs.hilt.android.compiler)

    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.javax.inject)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.foundation.layout.android)
    implementation(libs.androidx.animation.android)


}