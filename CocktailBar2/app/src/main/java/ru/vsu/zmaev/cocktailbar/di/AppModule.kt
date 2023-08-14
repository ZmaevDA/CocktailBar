package ru.vsu.zmaev.cocktailbar.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.vsu.zmaev.cocktailbar.domain.usecase.AddCocktailUseCase
import ru.vsu.zmaev.cocktailbar.domain.usecase.EditCocktailUseCase
import ru.vsu.zmaev.cocktailbar.domain.usecase.GetCocktailListUseCase
import ru.vsu.zmaev.cocktailbar.presentation.screen.CocktailsViewModelFactory

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideCocktailsViewModelFactory(
        getCocktailListUseCase: GetCocktailListUseCase,
        addCocktailUseCase: AddCocktailUseCase
    ): CocktailsViewModelFactory {
        return CocktailsViewModelFactory(
            getCocktailListUseCase = getCocktailListUseCase,
            addCocktailUseCase = addCocktailUseCase)
    }
}