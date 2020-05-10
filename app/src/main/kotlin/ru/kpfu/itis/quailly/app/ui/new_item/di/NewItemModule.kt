package ru.kpfu.itis.quailly.app.ui.new_item.di

import androidx.lifecycle.ViewModel
import ru.kpfu.itis.quailly.app.ui.new_item.NewItemViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelKey

@Module
interface NewItemModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewItemViewModel::class)
    fun providNewItemViewModel(newItemViewModel: NewItemViewModel): ViewModel
}