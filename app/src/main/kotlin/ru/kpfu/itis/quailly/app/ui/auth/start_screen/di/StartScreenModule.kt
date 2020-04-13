package ru.kpfu.itis.quailly.app.ui.auth.start_screen.di

import androidx.lifecycle.ViewModel
import ru.kpfu.itis.quailly.app.ui.auth.start_screen.StartScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelKey

@Module
interface StartScreenModule {

    @Binds
    @IntoMap
    @ViewModelKey(StartScreenViewModel::class)
    fun provideStartScreenViewModel(startScreenViewModel: StartScreenViewModel): ViewModel
}
