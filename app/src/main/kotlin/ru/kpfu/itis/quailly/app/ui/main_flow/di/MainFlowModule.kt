package ru.kpfu.itis.quailly.app.ui.main_flow.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.quailly.app.ui.main_flow.MainFlowViewModel
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelKey

@Module
interface MainFlowModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainFlowViewModel::class)
    fun provideMainFlowViewModel(mainFlowViewModel: MainFlowViewModel): ViewModel
}