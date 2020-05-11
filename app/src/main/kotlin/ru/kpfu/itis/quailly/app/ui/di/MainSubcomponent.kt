package ru.kpfu.itis.quailly.app.ui.di

import dagger.Subcomponent
import ru.kpfu.itis.quailly.app.ui.MainActivity
import ru.kpfu.itis.quailly.app.ui.auth.start_screen.di.StartScreenSubcomponent
import ru.kpfu.itis.quailly.app.ui.main_flow.di.MainFlowSubcomponent
import ru.kpfu.itis.quailly.app.ui.new_item.di.NewItemSubcomponent
import ru.kpfu.itis.quailly.app.ui.new_item.photo_chooser.di.PhotoChooserSubcomponent
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
    fun newItemSubcomponentBuilder(): NewItemSubcomponent.Builder
    fun photoChooserSubcomponentBuilder(): PhotoChooserSubcomponent.Builder
    fun mainFlowSubcomponentBuilder(): MainFlowSubcomponent.Builder
}
