import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.dependencies

object Deps{
    val kotlinVersion = "1.3.10"
    val compileSdkVersion = 28
    val minSdkVersion = 21
    val targetSdkVersion = 28
    val kotlinstbLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.10"
    val appCompat = "androidx.appcompat:appcompat:1.0.2"
    val coreKtx = "androidx.core:core-ktx:1.1.0-alpha03"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    val androidMaterial = "com.google.android.material:material:1.0.0"
    val junit = "junit:junit:4.12"
    val androidxTestRunner = "androidx.test:runner:1.1.1"
    val espressoCore = "androidx.test.espresso:espresso-core:3.1.1"
}

fun Project.androidProject(){
    dependencies {
        "implementation"(Deps.appCompat)
        "testImplementation"(Deps.junit)
    }
}

fun DependencyHandlerScope.commonDependencies() {
    "implementation"(Deps.appCompat)
    "implementation"(Deps.kotlinstbLib)
    "implementation"(Deps.constraintLayout)
    "testImplementation"(Deps.junit)
    "androidTestImplementation"(Deps.espressoCore)
}

fun LibraryExtension.commonAndroidConfig(){
    compileSdkVersion (Deps.compileSdkVersion)

    defaultConfig {
        minSdkVersion (Deps.minSdkVersion)
        targetSdkVersion (Deps.targetSdkVersion)
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"

    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}