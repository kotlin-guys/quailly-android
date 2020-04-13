package ru.kpfu.itis.quailly.app.ui.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.quailly.app.ui.MainViewModel
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelKey
import ru.kpfu.itis.quailly.app.ui.utils.resource_provider.ResourceProvider
import ru.kpfu.itis.quailly.app.ui.utils.resource_provider.ResourceProviderImpl

@Module
interface MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun provideMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    fun provideResourceProvider(resourceProviderImpl: ResourceProviderImpl): ResourceProvider
}
