package com.islamzada.data.di

import com.islamzada.data.repo.RecipeRepository
import com.islamzada.data.repo.RecipeRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun providerRecipeRepository(repository: RecipeRepository) : RecipeRepositoryInterface
}