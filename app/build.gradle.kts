plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "app.dpc.kid"
    compileSdk = 35

    defaultConfig {
        applicationId = "app.dpc.kid"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    signingConfigs {
        create("release") {
            storeFile = file(System.getenv("ANDROID_KEYSTORE_PATH") ?: "${'$'}{rootDir}/release.keystore")
            storePassword = System.getenv("ANDROID_STORE_PASSWORD") ?: ""
            keyAlias = System.getenv("ANDROID_KEY_ALIAS") ?: ""
            keyPassword = System.getenv("ANDROID_KEY_PASSWORD") ?: ""
        }
    }

    buildTypes {
    getByName("debug") { }

    // 🔧 이미 존재하는 release를 가져와서 수정
    getByName("release") {
        isMinifyEnabled = false
        isShrinkResources = false

        // 서명키 없으면 debug 서명으로 빌드되게
        val hasKeystore = file(System.getenv("ANDROID_KEYSTORE_PATH") ?: "${'$'}{rootDir}/release.keystore").exists() &&
                (System.getenv("ANDROID_KEY_ALIAS") ?: "").isNotEmpty()
        signingConfig = if (hasKeystore)
            signingConfigs.getByName("release")
        else
            signingConfigs.getByName("debug")
    }
}


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }
    buildFeatures { viewBinding = true }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.24")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
}
