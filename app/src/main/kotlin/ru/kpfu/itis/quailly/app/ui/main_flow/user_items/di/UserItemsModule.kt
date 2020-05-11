package ru.kpfu.itis.quailly.app.ui.main_flow.user_items.di

import androidx.lifecycle.ViewModel
import ru.kpfu.itis.quailly.app.ui.main_flow.user_items.UserItemsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelKey

@Module
interface UserItemsModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserItemsViewModel::class)
    fun provideProfileViewModel(userItemsViewModel: UserItemsViewModel): ViewModel
}