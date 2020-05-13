import Modules.implementData
import Modules.implementDevice
import Modules.implementCore

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(AndroidSdk.compileSdkVersion)
    buildToolsVersion(AndroidSdk.buildToolsVersion)
    defaultConfig {
        applicationId = "ru.kpfu.itis.quailly"
        minSdkVersion(AndroidSdk.minSdkVersion)
        targetSdkVersion(AndroidSdk.targetSdkVersion)
        versionCode = Versioning.version.code
        versionName = Versioning.version.name
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    dataBinding {
        isEnabled = true
    }

    buildTypes {
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isDebuggable = true
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
            isTestCoverageEnabled = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    //TODO: подумать о том, как вынести в project-level билд (скорее всего в subprojects)
    sourceSets {
        sourceSets.getByName("main") {
            java.srcDir("src/main/kotlin")
        }
    }
}

dependencies {
    implementData()
    implementDevice()
    implementCore()

    implementation(Libraries.coroutinesAndroid)

    implementation(Libraries.javax)
    implementation(Libraries.dagger)
    kapt(Libraries.daggerCompiler)

    implementation(Libraries.googleAuth)
    implementation(Libraries.recyclerWithChoice)

    implementation(Libraries.Retrofit.jsonConverter)
    implementation(Libraries.Retrofit.retrofit)
    implementation(Libraries.Retrofit.logging)
    implementation(Libraries.Retrofit.okHttp)

    implementation(Libraries.AndroidX.core)
    implementation(Libraries.AndroidX.appcompat)
    implementation(Libraries.AndroidX.activity)
    implementation(Libraries.AndroidX.fragment)
    implementation(Libraries.AndroidX.lifecycleExtensions)
    implementation(Libraries.AndroidX.lifecycleLiveData)
    implementation(Libraries.AndroidX.lifecycleViewModel)
    implementation(Libraries.AndroidX.material)
    implementation(Libraries.AndroidX.constraintlayout)
    implementation(Libraries.AndroidX.navigationFragment)
    implementation(Libraries.AndroidX.navigationUI)

    implementation(Libraries.Glide.glide)

    annotationProcessor(Libraries.Glide.compiler)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.junitAndroid)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
}