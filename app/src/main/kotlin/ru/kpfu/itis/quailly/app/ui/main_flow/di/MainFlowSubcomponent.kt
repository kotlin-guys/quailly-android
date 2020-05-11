package ru.kpfu.itis.quailly.app.ui.main_flow.di

import dagger.Subcomponent
import ru.kpfu.itis.quailly.app.ui.main_flow.MainFlowFragment
import ru.kpfu.itis.quailly.app.ui.main_flow.all_items.di.AllItemsSubcomponent
import ru.kpfu.itis.quailly.app.ui.main_flow.profile.di.ProfileSubcomponent
import ru.kpfu.itis.quailly.app.ui.main_flow.user_items.di.UserItemsSubcomponent
import ru.kpfu.itis.quailly.core.di.PerFragment

@Subcomponent(modules = [MainFlowModule::class])
@PerFragment
interface MainFlowSubcomponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): MainFlowSubcomponent
    }

    fun inject(mainFlowFragment: MainFlowFragment)

    fun allItemsSubcomponent(): AllItemsSubcomponent.Builder
    fun profileSubcomponent(): ProfileSubcomponent.Builder
    fun userItemsSubcomponent(): UserItemsSubcomponent.Builder
}