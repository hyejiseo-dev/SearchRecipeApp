package com.hjseo.recipeapp.presentation.ui.recipe_list

import androidx.lifecycle.ViewModel
import com.hjseo.recipeapp.network.model.RecipeDtoMapper
import com.hjseo.recipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel
@Inject
constructor(
    private val randomString: String,
    private val repository: RecipeRepository,
    @Named("auth_token") private val token : String,
) : ViewModel(){

    init {
    }

    fun getRepo() = repository

    fun getRandom() = randomString

    fun getToken() = token
}