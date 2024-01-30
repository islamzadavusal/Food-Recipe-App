package com.islamzada.entities.uimodel

data class RecipeUIState (
    val recipes: List<RecipeListUIModel>)

data class RecipeListUIModel(
    var id: Int,
    var title: String,
    var image: String)