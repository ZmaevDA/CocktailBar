package ru.vsu.zmaev.cocktailbar.data.repository

import ru.vsu.zmaev.cocktailbar.data.dao.CocktailDao
import ru.vsu.zmaev.cocktailbar.data.mapper.mapToDomain
import ru.vsu.zmaev.cocktailbar.data.mapper.mapToEntity
import ru.vsu.zmaev.cocktailbar.domain.model.Cocktail
import ru.vsu.zmaev.cocktailbar.domain.repository.CocktailRepository
import javax.inject.Inject

class CocktailRepositoryImpl @Inject constructor(
    private val dao: CocktailDao
) : CocktailRepository {
    override suspend fun getCocktailList(): List<Cocktail> {
        return dao.getAll().map { it.mapToDomain() }
    }

    override suspend fun getCocktailById(id: Long): Cocktail? {
        return dao.getById(id)?.mapToDomain()
    }

    override suspend fun insertCocktail(cocktail: Cocktail): Long {
        return dao.insert(cocktail.mapToEntity())
    }

    override suspend fun updateCocktail(cocktail: Cocktail) {
        return dao.update(cocktail.mapToEntity())
    }

    override suspend fun deleteCocktailById(id: Long) {
        return dao.deleteById(id)
    }
}