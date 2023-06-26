plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kapt)
}

android {
    compileSdk = Config.compileSkd
}

dependencies {
    modules(listOf(Dependencies.Modules.domain, Dependencies.Modules.commons))
    implementations(DependencyGroups.commonKotlin)
    implementations(DependencyGroups.network)
    implementation(Dependencies.Di.koin)
}