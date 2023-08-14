package ru.vsu.zmaev.cocktailbar.domain.usecase

import ru.vsu.zmaev.cocktailbar.domain.repository.CocktailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.vsu.zmaev.cocktailbar.domain.model.Cocktail
import ru.vsu.zmaev.cocktailbar.presentation.state.ScreenState

class GetCocktailListUseCase(
    private val cocktailRepository: CocktailRepository
) {
    suspend fun execute(): Flow<ScreenState> {
        return buildRequestFlow {
            cocktailRepository.getCocktailList()
        }
    }

    private fun buildRequestFlow(
        request: suspend () -> List<Cocktail>
    ): Flow<ScreenState> {
        return flow {
            emit(ScreenState.Loading)
            val newsUiState = when (val requestState = request()) {
                requestState.isNotEmpty() -> ScreenState.Success(requestState.value.articles)
                else -> NewsUiState.Error(requestState as ErrorState)
            }
            emit(newsUiState)
        }
    }
}