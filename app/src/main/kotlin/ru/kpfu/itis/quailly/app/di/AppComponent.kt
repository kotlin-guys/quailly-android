package ru.kpfu.itis.quailly.app.di

import android.content.Context
import ru.kpfu.itis.quailly.app.App
import dagger.BindsInstance
import dagger.Component
import ru.kpfu.itis.quailly.app.ui.di.MainSubcomponent
import ru.kpfu.itis.quailly.core.di.PerApp

@PerApp
@Component(modules = [])
interface AppComponent {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance appContext: Context): AppComponent
    }

    fun inject(app: App)

    fun mainSubcomponentBuilder(): MainSubcomponent.Builder
}
