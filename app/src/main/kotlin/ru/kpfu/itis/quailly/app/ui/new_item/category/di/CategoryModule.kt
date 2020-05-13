package ru.kpfu.itis.quailly.app.ui.new_item.category.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.quailly.app.ui.new_item.category.CategoryViewModel
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelKey

@Module
interface CategoryModule {

    @Binds
    @IntoMap
    @ViewModelKey(CategoryViewModel::class)
    fun providPhotoChooserViewModel(categoryViewModel: CategoryViewModel): ViewModel
}