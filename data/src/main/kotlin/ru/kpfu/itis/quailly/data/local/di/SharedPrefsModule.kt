package ru.kpfu.itis.quailly.data.local.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.kpfu.itis.quailly.core.di.PerApp
import ru.kpfu.itis.quailly.data.local.shared_prefs.SharedPrefsProvider
import ru.kpfu.itis.quailly.data.local.shared_prefs.SharedPrefsProviderImpl

@Module
abstract class SharedPrefsModule {

    @Module
    companion object {
        private const val NAME_SHARED_PREFS = "object_tracking_shared_prefs"

        @Provides
        @PerApp
        @JvmStatic
        fun provideSharedPrefs(context: Context) = context.getSharedPreferences(NAME_SHARED_PREFS, Context.MODE_PRIVATE)
    }

    @Binds
    @PerApp
    abstract fun provideSharedPrefsProvider(sharedPrefsProviderImpl: SharedPrefsProviderImpl): SharedPrefsProvider
}
