import BuildPlugins.Versions.buildToolsVersion
import Libraries.AndroidX.Versions.activityVersion
import Libraries.AndroidX.Versions.appcompatVersion
import Libraries.AndroidX.Versions.constraintlayoutVersion
import Libraries.AndroidX.Versions.coreVersion
import Libraries.AndroidX.Versions.fragmentVersion
import Libraries.AndroidX.Versions.lifecycleVersion
import Libraries.AndroidX.Versions.livedataVersion
import Libraries.AndroidX.Versions.materialVersion
import Libraries.AndroidX.Versions.multidexVersion
import Libraries.AndroidX.Versions.pagingVersion
import Libraries.AndroidX.Versions.recyclerviewVersion
import Libraries.Glide.Versions.glideVersion
import Libraries.Retrofit.Versions.okHttpVersion
import Libraries.Retrofit.Versions.retrofitVersion
import Libraries.Versions.coroutinesVersion
import Libraries.Versions.daggerVersion
import Libraries.Versions.googleAuthVersion
import Libraries.Versions.javaxInjectVersion
import Libraries.Versions.lottieVersion
import Libraries.Versions.recyclerChoiceVersion
import TestLibraries.Versions.androidJunitVersion
import TestLibraries.Versions.espressoVersion
import TestLibraries.Versions.junitVersion
import TestLibraries.Versions.testRunnerVersion

const val kotlinVersion = "1.3.61"
const val navigationVersion = "2.3.0-alpha03"

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "3.6.0"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val navigationGradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion"
}

object AndroidSdk {

    const val buildToolsVersion = "29.0.2"
    const val minSdkVersion = 23
    const val targetSdkVersion = 29
    const val compileSdkVersion = 29
}

object Libraries {

    object Versions {
        const val coroutinesVersion = "1.3.0"
        const val javaxInjectVersion = "1"
        const val daggerVersion = "2.25.2"
        const val lottieVersion = "3.4.0"
        const val googleAuthVersion = "18.0.0"
        const val recyclerChoiceVersion = "2.3.0"
    }

    const val kotlinStd = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"

    const val javax = "javax.inject:javax.inject:$javaxInjectVersion"
    const val dagger = "com.google.dagger:dagger:$daggerVersion"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:$daggerVersion"

    const val lottie = "com.airbnb.android:lottie:$lottieVersion"
    const val googleAuth = "com.google.android.gms:play-services-auth:$googleAuthVersion"
    const val recyclerWithChoice = "com.davidecirillo.multichoicerecyclerview:multichoicerecyclerview:$recyclerChoiceVersion"

    object AndroidX {

        object Versions {
            const val activityVersion = "1.0.0"
            const val fragmentVersion = "1.2.0"
            const val appcompatVersion = "1.1.0"
            const val coreVersion = "1.1.0"
            const val constraintlayoutVersion = "2.0.0-beta4"
            const val recyclerviewVersion = "1.2.0-alpha01"
            const val lifecycleVersion = "2.1.0"
            const val multidexVersion = "2.0.1"
            const val materialVersion = "1.2.0-alpha03"
            const val livedataVersion = "2.2.0-rc03"
            const val pagingVersion = "2.1.1"
        }

        const val activity = "androidx.activity:activity-ktx:$activityVersion"
        const val fragment = "androidx.fragment:fragment-ktx:$fragmentVersion"
        const val appcompat = "androidx.appcompat:appcompat:$appcompatVersion"
        const val core = "androidx.core:core-ktx:$coreVersion"
        const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:$constraintlayoutVersion"
        const val recyclerview = "androidx.recyclerview:recyclerview:$recyclerviewVersion"
        const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:$lifecycleVersion"
        const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:$lifecycleVersion"
        const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:$livedataVersion"
        const val lifecycleViewModel =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
        const val multidex = "androidx.multidex:multidex:$multidexVersion"
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:$navigationVersion"
        const val material = "com.google.android.material:material:$materialVersion"
        const val paging = "androidx.paging:paging-runtime:$pagingVersion"
    }

    object Glide {

        object Versions {
            const val glideVersion = "4.11.0"
        }

        const val glide = "com.github.bumptech.glide:glide:$glideVersion"
        const val compiler = "com.github.bumptech.glide:compiler:$glideVersion"
    }

    object Retrofit {

        object Versions {
            const val retrofitVersion = "2.7.1"
            const val okHttpVersion = "4.3.1"
        }

        const val jsonConverter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
        const val logging = "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"
    }
}

object TestLibraries {

    object Versions {
        const val junitVersion = "4.13"
        const val androidJunitVersion = "1.1.1"
        const val espressoVersion = "3.2.0"
        const val testRunnerVersion = "1.1.0-alpha4"
    }

    const val junit4 = "junit:junit:$junitVersion"
    const val junitAndroid = "androidx.test.ext:junit:$androidJunitVersion"
    const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"
    const val testRunner = "androidx.test:runner:$testRunnerVersion"
}
