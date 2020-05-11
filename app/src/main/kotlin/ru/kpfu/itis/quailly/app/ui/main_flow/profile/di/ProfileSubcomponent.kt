package ru.kpfu.itis.quailly.app.ui.main_flow.profile.di

import ru.kpfu.itis.quailly.app.ui.main_flow.profile.ProfileFragment
import dagger.Subcomponent
import ru.kpfu.itis.quailly.app.ui.main_flow.di.PerMainFlow

@Subcomponent(modules = [ProfileModule::class])
@PerMainFlow
interface ProfileSubcomponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): ProfileSubcomponent
    }

    fun inject(profileFragment: ProfileFragment)
}