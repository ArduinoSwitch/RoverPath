plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.serialization)
}

android {
    compileSdk = Config.compileSkd
}

dependencies {
    modules(listOf(Dependencies.Modules.commons))
    implementations(DependencyGroups.commonKotlin)
    implementation(Dependencies.Di.koin)
    implementation(Dependencies.Kotlin.kotlinxSerialization)
}