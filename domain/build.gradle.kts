plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.parcelize)

}

android {
    compileSdk = 34
    namespace = "com.mohammedalaa.domain"
}

dependencies {
    libs.apply {
        implementation(javax.inject)
        implementation(hilt.android)
        "ksp" (libs.hilt.android.compiler)
    }
}