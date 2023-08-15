package com.hjseo.recipeapp.network.model

import com.hjseo.recipeapp.domain.model.Recipe
import com.hjseo.recipeapp.domain.util.DomainMapper
import com.hjseo.recipeapp.network.RecipeDto

class RecipeDtoMapper : DomainMapper<RecipeDto, Recipe> {
    override fun mapToDomainModel(model: RecipeDto): Recipe {
        return Recipe(
            id = model.pk,
            title = model.title,
            featuredImage = model.featured_image,
            rating = model.rating,
            publisher = model.publisher,
            sourceUrl = model.sourceUrl,
            description = model.description,
            cookingInstructions = model.cooking_instructions,
            ingredients = model.ingredients?: listOf(),
            dateAdded = model.date_added,
            dateUpdated = model.date_updated
        )
    }

    override fun mapFromDomainModel(domainModel: Recipe): RecipeDto {
        return RecipeDto(
            pk = domainModel.id,
            title = domainModel.title,
            featured_image = domainModel.featuredImage,
            rating = domainModel.rating,
            publisher = domainModel.publisher,
            sourceUrl = domainModel.sourceUrl,
            description = domainModel.description,
            cooking_instructions = domainModel.cookingInstructions,
            ingredients = domainModel.ingredients?: listOf(),
            date_added = domainModel.dateAdded,
            date_updated = domainModel.dateUpdated
        )
    }

    fun toDomainList(initial: List<RecipeDto>) : List<Recipe>{
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Recipe>): List<RecipeDto>{
        return initial.map { mapFromDomainModel(it)}
    }

}