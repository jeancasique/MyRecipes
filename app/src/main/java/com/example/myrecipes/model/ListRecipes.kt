package com.example.myrecipes.model

import android.os.Parcelable
import com.example.myrecipes.categorias.Category
import kotlinx.serialization.*
import kotlinx.parcelize.Parcelize

@Parcelize
@Serializable
data class Ingredient(
    val quantity: String,
    val ingredient: String
) : Parcelable

@Parcelize
@Serializable
data class Recipe(
    val title: String,
    val image: String,
    val ingredients: List<Ingredient>,
    @SerialName("categories")
    val rawCategories: List<String>,
    val instructions: String,
    val favorite: Boolean
) : Parcelable {
    val categories: List<Category>
        get() = rawCategories.map {
            Category.valueOf(it)
        }

    companion object {
        val KEY_ARG = "recipe"
    }
}

@Serializable
data class ListRecipes(
    @SerialName("recipes") val listRecipes: List<Recipe>
)