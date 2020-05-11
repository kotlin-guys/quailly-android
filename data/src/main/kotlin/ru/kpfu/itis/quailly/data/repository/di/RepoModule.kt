package ru.kpfu.itis.quailly.data.repository.di

import dagger.Binds
import dagger.Module
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import ru.kpfu.itis.quailly.core.di.PerApp
import ru.kpfu.itis.quailly.data.repository.auth.AuthRepoImpl
import ru.kpfu.itis.quailly.data.repository.category.CategoryRepositoryImpl
import ru.kpfu.itis.quailly.data.repository.image.PhotoRepositoryImpl
import ru.kpfu.itis.quailly.domain.repo.AuthRepo
import ru.kpfu.itis.quailly.domain.repo.CategoryRepository
import ru.kpfu.itis.quailly.domain.repo.PhotoRepository

@FlowPreview
@ExperimentalCoroutinesApi
@Module
interface RepoModule {

    @Binds
    @PerApp
    fun bind1(repo: AuthRepoImpl): AuthRepo

    @Binds
    @PerApp
    fun bind2(repo: PhotoRepositoryImpl): PhotoRepository

    @Binds
    @PerApp
    fun bind3(repo: CategoryRepositoryImpl): CategoryRepository
}