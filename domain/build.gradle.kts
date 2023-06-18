plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = Config.compileSkd
}

dependencies {
    modules(listOf(Dependencies.Modules.data))
    implementations(DependencyGroups.commonKotlin)
    implementation(Dependencies.Di.koin)
}