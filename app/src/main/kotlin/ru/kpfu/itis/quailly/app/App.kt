package ru.kpfu.itis.quailly.app

import android.app.Activity
import android.app.Application
import ru.kpfu.itis.quailly.app.di.AppComponent
import ru.kpfu.itis.quailly.app.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory()
            .create(this)
        appComponent.inject(this)
    }
}

fun Activity.getAppComponent(): AppComponent = (application as App).appComponent
