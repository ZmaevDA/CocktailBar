package ru.vsu.zmaev.cocktailbar.domain.repository

import ru.vsu.zmaev.cocktailbar.domain.model.Cocktail

interface CocktailRepository {

    suspend fun getCocktailList(): List<Cocktail>

    suspend fun getCocktailById(id: Long): Cocktail?

    suspend fun insertCocktail(cocktail: Cocktail): Long

    suspend fun updateCocktail(cocktail: Cocktail)

    suspend fun deleteCocktailById(id: Long)
}