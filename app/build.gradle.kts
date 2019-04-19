
plugins{
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(Deps.compileSdkVersion)
    defaultConfig {
        applicationId = "org.athaliapps.gradlekotlinbuildsrc"
        minSdkVersion (Deps.minSdkVersion)
        targetSdkVersion (Deps.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    commonDependencies()
    project(":module1")
    project(":module2")
}
