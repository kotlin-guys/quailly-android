package ru.kpfu.itis.quailly.app.ui.new_item.di

import ru.kpfu.itis.quailly.app.ui.new_item.NewItemFragment
import dagger.Subcomponent
import ru.kpfu.itis.quailly.core.di.PerFragment

@Subcomponent(modules = [NewItemModule::class])
@PerFragment
interface NewItemSubcomponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): NewItemSubcomponent
    }

    fun inject(newItemFragment: NewItemFragment)
}