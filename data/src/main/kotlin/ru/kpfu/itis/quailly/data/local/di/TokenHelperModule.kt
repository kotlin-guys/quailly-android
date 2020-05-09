package ru.kpfu.itis.quailly.data.local.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.quailly.core.di.PerApp
import ru.kpfu.itis.quailly.data.local.token_helper.TokenHelper
import ru.kpfu.itis.quailly.data.local.token_helper.TokenHelperImpl

@Module
interface TokenHelperModule {

    @Binds
    @PerApp
    fun bind(tokenHelperImpl: TokenHelperImpl): TokenHelper
}