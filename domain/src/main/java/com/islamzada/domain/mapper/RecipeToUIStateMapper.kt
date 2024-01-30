package com.islamzada.domain.mapper

import com.islamzada.entities.models.Recipes
import com.islamzada.entities.uimodel.RecipeListUIModel
import com.islamzada.entities.uimodel.RecipeUIState
import javax.inject.Inject

class RecipeToUIStateMapper @Inject constructor() : BaseMapper<Recipes, RecipeUIState> {
    override fun map(input: Recipes): RecipeUIState {
        return RecipeUIState(
            recipes = input.getRecipes()
        )
    }

    private fun Recipes.getRecipes() : List<RecipeListUIModel> {
        return results?.map {
            RecipeListUIModel(
                id = it.id!!,
                image = it.image!!,
                title = it.title!!)
        } ?: listOf()
    }
}