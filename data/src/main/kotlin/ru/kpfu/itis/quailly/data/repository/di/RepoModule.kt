package ru.kpfu.itis.quailly.data.repository.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.quailly.core.di.PerApp
import ru.kpfu.itis.quailly.data.repository.auth.AuthRepoImpl
import ru.kpfu.itis.quailly.domain.repo.AuthRepo

@Module
interface RepoModule {

    @Binds
    @PerApp
    fun bind1(repo: AuthRepoImpl): AuthRepo
}