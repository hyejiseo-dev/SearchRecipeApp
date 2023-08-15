package com.hjseo.recipeapp.di

import com.hjseo.recipeapp.network.RecipeService
import com.hjseo.recipeapp.network.model.RecipeDtoMapper
import com.hjseo.recipeapp.repository.RecipeRepository
import com.hjseo.recipeapp.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository{
        return RecipeRepositoryImpl(
            recipeService, recipeDtoMapper
        )
    }
}