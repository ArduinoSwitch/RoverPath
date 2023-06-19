plugins {
    id("com.android.library")
    id("kotlin-android")
    id ("kotlin-parcelize")
    id ("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    viewBinding {
        enable = true
    }
}

dependencies {
    implementations(DependencyGroups.diUi)
    implementations(DependencyGroups.commonAndroid)
    implementations(DependencyGroups.commonKotlin)
    implementations(DependencyGroups.ui)
    implementations(DependencyGroups.navigation)
    implementation(Dependencies.Kotlin.kotlinxSerialization)
    implementation(Dependencies.Database.datastorePreferences)
}