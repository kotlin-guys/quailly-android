import Modules.implementCore

plugins {
    id("kotlin")
    kotlin("kapt")
}

dependencies {
    implementCore()

    api(Libraries.kotlinStd)
    api(Libraries.coroutinesCore)
    api(Libraries.javax)
    api(Libraries.dagger)
    kapt(Libraries.daggerCompiler)
}