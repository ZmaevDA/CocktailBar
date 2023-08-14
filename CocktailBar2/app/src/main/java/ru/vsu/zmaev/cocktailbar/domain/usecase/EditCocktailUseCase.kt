package ru.vsu.zmaev.cocktailbar.domain.usecase

import ru.vsu.zmaev.cocktailbar.domain.model.Cocktail
import ru.vsu.zmaev.cocktailbar.domain.repository.CocktailRepository

class EditCocktailUseCase(
    private val cocktailRepository: CocktailRepository
) {
    suspend fun execute(params: Cocktail) = cocktailRepository.updateCocktail(params)
}