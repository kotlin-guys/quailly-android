package ru.kpfu.itis.quailly.app.ui.new_item.photo_chooser.di

import ru.kpfu.itis.quailly.app.ui.new_item.photo_chooser.PhotoChooserBottomSheet
import dagger.Subcomponent
import ru.kpfu.itis.quailly.core.di.PerFragment

@Subcomponent(modules = [PhotoChooserModule::class])
@PerFragment
interface PhotoChooserSubcomponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): PhotoChooserSubcomponent
    }

    fun inject(photoChooserBottomSheet: PhotoChooserBottomSheet)
}