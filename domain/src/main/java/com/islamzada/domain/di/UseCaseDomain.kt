package com.islamzada.domain.di

import com.islamzada.data.repo.RecipeRepositoryInterface
import com.islamzada.domain.usecase.RecipeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseDomain {

    @Provides
    @Singleton
    fun provideRecipeUseCase(repositoryInterface: RecipeRepositoryInterface) = RecipeUseCase(repositoryInterface)
}