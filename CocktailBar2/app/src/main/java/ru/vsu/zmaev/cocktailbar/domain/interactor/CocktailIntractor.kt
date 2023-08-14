package ru.vsu.zmaev.cocktailbar.domain.interactor

import ru.vsu.zmaev.cocktailbar.domain.model.Cocktail
import ru.vsu.zmaev.cocktailbar.domain.repository.CocktailRepository
import javax.inject.Inject

class CocktailIntractor @Inject constructor(
    private val repository: CocktailRepository
) {
    suspend fun getCocktails(): List<Cocktail> {
        return repository.getCocktailList()
    }

    suspend fun getCocktailById(id: Long): Cocktail? {
        return repository.getCocktailById(id)
    }

    suspend fun addCocktail(cocktail: Cocktail): Long {
        return repository.insertCocktail(cocktail)
    }

    suspend fun updateCocktail(cocktail: Cocktail) {
        repository.updateCocktail(cocktail)
    }

    suspend fun deleteCocktailById(id: Long) {
        repository.deleteCocktailById(id)
    }
}