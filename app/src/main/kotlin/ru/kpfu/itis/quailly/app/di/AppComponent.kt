package ru.kpfu.itis.quailly.app.di

import android.content.Context
import ru.kpfu.itis.quailly.app.App
import dagger.BindsInstance
import dagger.Component
import ru.kpfu.itis.quailly.app.ui.di.MainSubcomponent
import ru.kpfu.itis.quailly.core.di.PerApp
import ru.kpfu.itis.quailly.data.local.di.SharedPrefsModule
import ru.kpfu.itis.quailly.data.local.di.TokenHelperModule
import ru.kpfu.itis.quailly.data.network.di.QuaillyNetModule
import ru.kpfu.itis.quailly.data.repository.di.RepoModule

@PerApp
@Component(
    modules = [
        QuaillyNetModule::class,
        SharedPrefsModule::class,
        TokenHelperModule::class,
        RepoModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance appContext: Context): AppComponent
    }

    fun inject(app: App)

    fun mainSubcomponentBuilder(): MainSubcomponent.Builder
}
