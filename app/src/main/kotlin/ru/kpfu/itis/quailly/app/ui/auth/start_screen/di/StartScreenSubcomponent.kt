package ru.kpfu.itis.quailly.app.ui.auth.start_screen.di

import ru.kpfu.itis.quailly.app.ui.auth.start_screen.StartScreenFragment
import dagger.Subcomponent
import ru.kpfu.itis.quailly.core.di.PerFragment

@Subcomponent(modules = [StartScreenModule::class])
@PerFragment
interface StartScreenSubcomponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): StartScreenSubcomponent
    }

    fun inject(startScreenFragment: StartScreenFragment)
}
