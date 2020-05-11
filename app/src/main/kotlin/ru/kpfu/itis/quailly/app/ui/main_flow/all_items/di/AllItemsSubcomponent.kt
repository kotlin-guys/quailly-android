package ru.kpfu.itis.quailly.app.ui.main_flow.all_items.di

import dagger.Subcomponent
import ru.kpfu.itis.quailly.app.ui.main_flow.all_items.AllItemsFragment
import ru.kpfu.itis.quailly.app.ui.main_flow.di.PerMainFlow

@Subcomponent(modules = [AllItemsModule::class])
@PerMainFlow
interface AllItemsSubcomponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): AllItemsSubcomponent
    }

    fun inject(allItemsFragment: AllItemsFragment)
}