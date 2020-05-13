package ru.kpfu.itis.quailly.app.ui.new_item.desired_categories.di

import dagger.Subcomponent
import ru.kpfu.itis.quailly.app.ui.new_item.desired_categories.DesiredCategoriesBottomSheet
import ru.kpfu.itis.quailly.core.di.PerFragment

@Subcomponent(modules = [DesiredCategoriesModule::class])
@PerFragment
interface DesiredCategoriesSubcomponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): DesiredCategoriesSubcomponent
    }

    fun inject(cacategoryBottomSheet: DesiredCategoriesBottomSheet)
}