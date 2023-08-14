package ru.vsu.zmaev.cocktailbar.domain.model

data class Cocktail (
    val id: Long,
    val name: String,
    val description: String,
    val recipe: String,
    val ingredients: List<String>,
    val imagePath: String
)