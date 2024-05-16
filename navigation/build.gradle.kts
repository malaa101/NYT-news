plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.mohammedalaa.navigation"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
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
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {

    api(project(":domain"))
    implementation(project(":core"))
    implementation(project(":designsystem"))
    implementation(project(":feature:newslist"))
    implementation(project(":feature:newsdetails"))

    api(libs.androidx.navigation.compose)
    //implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.collections.immutable)
    implementation(libs.androidx.window)
    implementation(libs.accomponist.adaptive)
}