plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = Config.compileSkd

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSkd
        targetSdk = Config.targetSkd
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(Config.defaultProguardFile),
                file(Config.proguardRules)
            )
        }
    }

    viewBinding {
        enable = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = Config.jvtTarget
    }

    configurations {
    }
}

dependencies {
    modules(DependencyGroups.modules)
    implementations(DependencyGroups.commonKotlin)
    implementations(DependencyGroups.commonAndroid)
    implementations(DependencyGroups.diUi)
}