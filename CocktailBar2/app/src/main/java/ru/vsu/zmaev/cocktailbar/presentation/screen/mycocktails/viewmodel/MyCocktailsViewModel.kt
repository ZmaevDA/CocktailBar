package ru.vsu.zmaev.cocktailbar.presentation.screen.mycocktails.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.vsu.zmaev.cocktailbar.domain.usecase.GetCocktailListUseCase
import ru.vsu.zmaev.cocktailbar.presentation.state.ScreenState

class MyCocktailsViewModel(
    private val getCocktailsListUseCase: GetCocktailListUseCase
): ViewModel() {

    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.Empty)
    val screenState: StateFlow<ScreenState> = _screenState

    fun getCocktailsList() {
        viewModelScope.launch {
            getCocktailsListUseCase.execute().collect {
                when(it) {
                    is ScreenState.Success -> {
                        _screenState.emit(it)
                    }
                    is ScreenState.Loading -> _screenState.emit(ScreenState.Loading)
                    is ScreenState.Empty -> _screenState.emit(ScreenState.Empty)
                    is ScreenState.Error -> {}
                }
            }
        }
    }


}