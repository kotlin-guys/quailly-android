package ru.kpfu.itis.quailly.app.ui.new_item.photo_chooser.di

import androidx.lifecycle.ViewModel
import ru.kpfu.itis.quailly.app.ui.new_item.photo_chooser.PhotoChooserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelKey

@Module
interface PhotoChooserModule {

    @Binds
    @IntoMap
    @ViewModelKey(PhotoChooserViewModel::class)
    fun providPhotoChooserViewModel(photoChooserViewModel: PhotoChooserViewModel): ViewModel
}