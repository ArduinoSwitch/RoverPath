plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = Config.compileSkd
}

dependencies {
    implementations(DependencyGroups.commonKotlin)
    implementation(Dependencies.Di.koin)
    implementation(Dependencies.Database.roomRuntime)
    implementation(Dependencies.Database.roomKtx)
    implementation(Dependencies.Database.roomTest)
    implementation(Dependencies.Database.datastorePreferences)
    kapt(Dependencies.Database.roomCompiler)
}