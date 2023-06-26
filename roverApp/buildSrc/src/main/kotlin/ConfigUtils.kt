import org.gradle.api.Project
import org.gradle.api.plugins.BasePluginExtension
import org.gradle.api.plugins.ExtensionContainer

object Config {
    const val applicationId = "com.seat.rover"
    const val compileSkd = 33
    const val minSkd = 21
    const val targetSkd = 33
    const val versionCode = 1
    const val versionName = "1.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val defaultProguardFile = "proguard-android-optimize.txt"
    const val proguardRules = "proguard-rules.pro"
    const val jvtTarget = "1.8"
}
