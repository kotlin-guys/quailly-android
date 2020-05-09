import Modules.implementCore
import Modules.implementDomain

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(AndroidSdk.compileSdkVersion)
    buildToolsVersion(AndroidSdk.buildToolsVersion)
    defaultConfig {
        minSdkVersion(AndroidSdk.minSdkVersion)
        targetSdkVersion(AndroidSdk.targetSdkVersion)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            buildConfigField("String", "QUAILLY_BACK_URL", "\"http://quailly.herokuapp.com/\"")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("debug") {
            buildConfigField("String", "QUAILLY_BACK_URL", "\"http://quailly.herokuapp.com/\"")
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
    implementCore()
    implementDomain()

    implementation(Libraries.coroutinesAndroid)

    implementation(Libraries.Retrofit.jsonConverter)
    implementation(Libraries.Retrofit.retrofit)
    implementation(Libraries.Retrofit.logging)
    implementation(Libraries.Retrofit.okHttp)
    implementation(Libraries.javax)
    implementation(Libraries.dagger)
    kapt(Libraries.daggerCompiler)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.junitAndroid)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
}