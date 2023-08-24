package com.hjseo.recipeapp.presentation.ui.recipe_list

enum class FoodCategory (val value: String){
    CHICKEN("Chicken"),
    BEEF("Beef"),
    SOUP("Soup"),
    DESSERT("Dessert"),
    VEGAN("Vegan"),
    MILK("Milk"),
    PIZZA("Pizza"),
    DONUT("Donut"),
}

fun getAllFoodCategories(): List<FoodCategory>{
    return listOf(FoodCategory.CHICKEN, FoodCategory.BEEF,FoodCategory.DONUT,
        FoodCategory.SOUP, FoodCategory.DESSERT, FoodCategory.MILK, FoodCategory.PIZZA,FoodCategory.VEGAN)
}

fun getFoodCategory(value: String): FoodCategory?{
    val map = FoodCategory.values().associateBy(FoodCategory::value)
    return map[value]
}