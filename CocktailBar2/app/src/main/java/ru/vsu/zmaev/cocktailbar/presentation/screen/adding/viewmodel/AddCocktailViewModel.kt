package ru.vsu.zmaev.cocktailbar.presentation.screen.adding.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.vsu.zmaev.cocktailbar.domain.model.Cocktail
import ru.vsu.zmaev.cocktailbar.domain.usecase.AddCocktailUseCase
import ru.vsu.zmaev.cocktailbar.presentation.state.ScreenState

class AddCocktailViewModel(
    private val addCocktailUseCase: AddCocktailUseCase
): ViewModel() {
    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.Empty)
    val screenState: StateFlow<ScreenState> = _screenState

    fun addCocktail(cocktail: Cocktail) {
        viewModelScope.launch {
           val res = addCocktailUseCase.execute(cocktail)
        }
    }

    fun inputCheck(title: String, description: String, recipe: String): Boolean {
        return title.isNotBlank() && description.isNotBlank() && recipe.isNotBlank()
    }


}