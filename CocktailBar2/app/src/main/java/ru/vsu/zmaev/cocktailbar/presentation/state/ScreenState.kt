package ru.vsu.zmaev.cocktailbar.presentation.state

import ru.vsu.zmaev.cocktailbar.domain.model.Cocktail

sealed interface ScreenState {
    object Loading: ScreenState
    data class Success(val cocktails: List<Cocktail>): ScreenState
    object Error: ScreenState
    object Empty: ScreenState
}