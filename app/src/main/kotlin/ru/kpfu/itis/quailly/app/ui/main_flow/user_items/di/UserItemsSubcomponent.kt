package ru.kpfu.itis.quailly.app.ui.main_flow.user_items.di

import ru.kpfu.itis.quailly.app.ui.main_flow.user_items.UserItemsFragment
import dagger.Subcomponent
import ru.kpfu.itis.quailly.app.ui.main_flow.di.PerMainFlow

@Subcomponent(modules = [UserItemsModule::class])
@PerMainFlow
interface UserItemsSubcomponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): UserItemsSubcomponent
    }

    fun inject(userItemsFragment: UserItemsFragment)
}