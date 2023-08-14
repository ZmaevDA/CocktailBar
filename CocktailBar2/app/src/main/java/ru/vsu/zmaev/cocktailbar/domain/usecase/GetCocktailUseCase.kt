package ru.vsu.zmaev.cocktailbar.domain.usecase

import ru.vsu.zmaev.cocktailbar.domain.model.Cocktail
import ru.vsu.zmaev.cocktailbar.domain.repository.CocktailRepository

class GetCocktailUseCase(
    private val cocktailRepository: CocktailRepository
) {
    suspend fun execute(params: Long): Cocktail? =
        cocktailRepository.getCocktailById(params)
}