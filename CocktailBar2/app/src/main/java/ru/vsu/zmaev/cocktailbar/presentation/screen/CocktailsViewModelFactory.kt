package ru.vsu.zmaev.cocktailbar.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.vsu.zmaev.cocktailbar.domain.usecase.AddCocktailUseCase
import ru.vsu.zmaev.cocktailbar.domain.usecase.EditCocktailUseCase
import ru.vsu.zmaev.cocktailbar.domain.usecase.GetCocktailListUseCase
import ru.vsu.zmaev.cocktailbar.presentation.screen.adding.viewmodel.AddCocktailViewModel
import ru.vsu.zmaev.cocktailbar.presentation.screen.mycocktails.viewmodel.MyCocktailsViewModel
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class CocktailsViewModelFactory(
    val getCocktailListUseCase: GetCocktailListUseCase,
    val addCocktailUseCase: AddCocktailUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MyCocktailsViewModel::class.java) ->
                MyCocktailsViewModel(getCocktailsListUseCase = getCocktailListUseCase) as T
            modelClass.isAssignableFrom(AddCocktailViewModel::class.java) ->
                AddCocktailViewModel(addCocktailUseCase = addCocktailUseCase) as T
            else -> throw IllegalArgumentException("ViewModel not found!")
        }
    }
}