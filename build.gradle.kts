// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    libs.plugins.apply {
        alias(android.application) apply false
        alias(kotlin.parcelize) apply false
        alias(android.library) apply false
        alias(jetbrains.kotlin.android) apply false
        alias(hilt.android) apply false
        alias(ksp) apply false
    }
}