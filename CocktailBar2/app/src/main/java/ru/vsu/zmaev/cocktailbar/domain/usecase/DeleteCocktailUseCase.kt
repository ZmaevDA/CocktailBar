package ru.vsu.zmaev.cocktailbar.domain.usecase

import ru.vsu.zmaev.cocktailbar.domain.repository.CocktailRepository

class DeleteCocktailUseCase(
    private val cocktailRepository: CocktailRepository
) {
    suspend fun execute(params: Long) =
        cocktailRepository.deleteCocktailById(params)
}