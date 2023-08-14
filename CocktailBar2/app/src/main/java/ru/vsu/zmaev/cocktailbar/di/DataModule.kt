package ru.vsu.zmaev.cocktailbar.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.vsu.zmaev.cocktailbar.data.dao.CocktailDao
import ru.vsu.zmaev.cocktailbar.data.database.AppDatabase
import ru.vsu.zmaev.cocktailbar.data.repository.CocktailRepositoryImpl
import ru.vsu.zmaev.cocktailbar.domain.repository.CocktailRepository

@Module
class DataModule {

    @Provides
    fun provideDataBase(context: Context): AppDatabase {
        return AppDatabase.get(context)
    }

    @Provides
    fun provideCocktailDao(appDatabase: AppDatabase): CocktailDao {
        return appDatabase.cocktailDao()
    }

    @Provides
    fun provideCocktailRepository(cocktailDao: CocktailDao): CocktailRepository {
        return CocktailRepositoryImpl(cocktailDao)
    }
}