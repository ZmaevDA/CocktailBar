package ru.vsu.zmaev.cocktailbar.di

import dagger.Module
import dagger.Provides
import ru.vsu.zmaev.cocktailbar.domain.model.Cocktail
import ru.vsu.zmaev.cocktailbar.domain.repository.CocktailRepository
import ru.vsu.zmaev.cocktailbar.domain.usecase.AddCocktailUseCase
import ru.vsu.zmaev.cocktailbar.domain.usecase.GetCocktailListUseCase

@Module
class DomainModule {

    @Provides
    fun provideGetCocktailListUseCase(
        cocktailRepository: CocktailRepository
    ): GetCocktailListUseCase {
        return GetCocktailListUseCase(cocktailRepository)
    }

    @Provides
    fun provideAddCocktailUseCase(
        cocktailRepository: CocktailRepository
    ): AddCocktailUseCase {
        return AddCocktailUseCase(cocktailRepository)
    }

}