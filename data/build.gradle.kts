plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
}

android {
    compileSdk = Config.compileSkd
}

dependencies {
    modules(listOf(Dependencies.Modules.domain))
    implementations(DependencyGroups.commonKotlin)
    implementation(Dependencies.Di.koin)
    kapt(Dependencies.Database.roomCompiler)
    implementation(Dependencies.Database.roomRuntime)
    implementation(Dependencies.Database.roomKtx)
    implementation(Dependencies.Database.roomTest)
    implementation(Dependencies.Kotlin.kotlinxSerialization)
}