package ru.kpfu.itis.quailly.app.ui.new_item.category.di

import dagger.Subcomponent
import ru.kpfu.itis.quailly.app.ui.new_item.category.CategoryBottomSheet
import ru.kpfu.itis.quailly.app.ui.new_item.desired_categories.DesiredCategoriesBottomSheet
import ru.kpfu.itis.quailly.app.ui.new_item.desired_categories.di.DesiredCategoriesModule
import ru.kpfu.itis.quailly.app.ui.new_item.desired_categories.di.DesiredCategoriesSubcomponent
import ru.kpfu.itis.quailly.core.di.PerFragment

@Subcomponent(modules = [CategoryModule::class])
@PerFragment
interface CategorySubcomponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): CategorySubcomponent
    }

    fun inject(cacategoryBottomSheet: CategoryBottomSheet)
}