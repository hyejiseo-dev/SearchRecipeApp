package com.hjseo.recipeapp.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hjseo.recipeapp.domain.model.Recipe
import com.hjseo.recipeapp.network.model.RecipeDtoMapper
import com.hjseo.recipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.http.Query
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
    val recipes : MutableState<List<Recipe>> = mutableStateOf(listOf())
    val query = mutableStateOf("")
    val selectedCategory: MutableState<FoodCategory?> = mutableStateOf(null)
    init {
        newSearch()
    }

    fun newSearch(){
        viewModelScope.launch {
            val result = repository.search(
                token = token,
                page = 1,
                query = query.value
            )
            recipes.value = result
        }
    }

    fun onQueryChanged(query: String){
        this.query.value = query
    }

    fun onSelectedCategoryChanged(category: String){
        val newCategory = getFoodCategory(category)
        selectedCategory.value = newCategory
        onQueryChanged(category)
    }
}