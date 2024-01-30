package com.islamzada.network.api

import com.islamzada.entities.models.Recipes
import retrofit2.http.GET

interface ApiService {
    @GET("complexSearch")
    suspend fun getRecipe(): Recipes?
}