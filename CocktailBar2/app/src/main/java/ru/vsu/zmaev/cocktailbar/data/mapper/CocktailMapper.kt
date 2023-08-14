package ru.vsu.zmaev.cocktailbar.data.mapper

import ru.vsu.zmaev.cocktailbar.data.model.CocktailEntity
import ru.vsu.zmaev.cocktailbar.domain.model.Cocktail
import javax.inject.Inject

fun  Cocktail.mapToEntity(): CocktailEntity {
    return CocktailEntity(
        id = id,
        name = name,
        description = description,
        ingredients = ingredients,
        recipe = recipe,
        imagePath = imagePath
    )
}

fun CocktailEntity.mapToDomain(): Cocktail {
    return Cocktail(
        id = id,
        name = name,
        description = description,
        ingredients = ingredients,
        recipe = recipe,
        imagePath = imagePath
    )
}
