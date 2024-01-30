package com.islamzada.data.repo

import com.islamzada.entities.models.Recipes
import com.islamzada.network.api.ApiService
import javax.inject.Inject

interface RecipeRepositoryInterface {
    suspend fun getRecipe() : Recipes?
}

class RecipeRepository @Inject constructor(private val apiService : ApiService) : RecipeRepositoryInterface {
    override suspend fun getRecipe(): Recipes? {
        return apiService.getRecipe()
    }
}