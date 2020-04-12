package ru.kpfu.itis.quailly.app.ui.di

import dagger.Subcomponent
import ru.kpfu.itis.quailly.app.ui.MainActivity
import ru.kpfu.itis.quailly.app.ui.auth.start_screen.di.StartScreenSubcomponent
import ru.kpfu.itis.quailly.core.di.PerActivity

@Subcomponent(modules = [MainModule::class])
@PerActivity
interface MainSubcomponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): MainSubcomponent
    }

    fun inject(mainActivity: MainActivity)

    fun startScreenSubcomponentBuilder(): StartScreenSubcomponent.Builder
}
