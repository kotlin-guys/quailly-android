package ru.kpfu.itis.quailly.app.ui.new_item.desired_categories.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.quailly.app.ui.new_item.desired_categories.DesiredCategoriesViewModel
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelKey

@Module
interface DesiredCategoriesModule {

    @Binds
    @IntoMap
    @ViewModelKey(DesiredCategoriesViewModel::class)
    fun providPhotoChooserViewModel(categoryViewModel: DesiredCategoriesViewModel): ViewModel
}