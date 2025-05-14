plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.kotlinCocoapods) apply false
    alias(libs.plugins.kotlinJvm) apply false
    alias(libs.plugins.ktorfit) apply false
    alias(libs.plugins.androidKotlinMultiplatformLibrary) apply false
    alias(libs.plugins.googleKsp) apply false
}
