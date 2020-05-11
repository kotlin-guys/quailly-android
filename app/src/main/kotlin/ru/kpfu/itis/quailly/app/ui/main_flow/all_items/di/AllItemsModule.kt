package ru.kpfu.itis.quailly.app.ui.main_flow.all_items.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.quailly.app.ui.main_flow.all_items.AllItemsViewModel
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelKey

@Module
interface AllItemsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AllItemsViewModel::class)
    fun provideAllItemsViewModel(allItemsViewModel: AllItemsViewModel): ViewModel
}