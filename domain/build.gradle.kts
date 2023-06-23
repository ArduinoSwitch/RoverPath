plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = Config.compileSkd
}

dependencies {
    implementations(DependencyGroups.commonKotlin)
    implementation(Dependencies.Di.koin)
}