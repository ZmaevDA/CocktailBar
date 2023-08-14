package ru.vsu.zmaev.cocktailbar.di

import dagger.Component
import ru.vsu.zmaev.cocktailbar.presentation.screen.adding.AddCocktailFragment
import ru.vsu.zmaev.cocktailbar.presentation.screen.editing.EditCocktailFragment
import ru.vsu.zmaev.cocktailbar.presentation.screen.main.MainActivity
import ru.vsu.zmaev.cocktailbar.presentation.screen.mycocktails.MyCocktailsFragment

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(myCocktailsFragment: MyCocktailsFragment)
    fun inject(addCocktailFragment: AddCocktailFragment)
}