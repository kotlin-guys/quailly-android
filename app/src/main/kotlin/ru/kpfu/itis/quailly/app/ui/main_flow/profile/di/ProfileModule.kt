package ru.kpfu.itis.quailly.app.ui.main_flow.profile.di

import androidx.lifecycle.ViewModel
import ru.kpfu.itis.quailly.app.ui.main_flow.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelKey

@Module
interface ProfileModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    fun provideProfileViewModel(profileViewModel: ProfileViewModel): ViewModel
}