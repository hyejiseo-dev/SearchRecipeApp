package com.hjseo.recipeapp.network.responses

import com.google.gson.annotations.SerializedName
import com.hjseo.recipeapp.domain.model.Recipe

data class RecipeSearchResponse(
    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var recipes: List<Recipe>,
)