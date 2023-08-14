package ru.vsu.zmaev.cocktailbar.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ru.vsu.zmaev.cocktailbar.util.StringListConverter

@Entity(tableName = "cocktail")
@TypeConverters(StringListConverter::class)
data class CocktailEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "ingredients")
    val ingredients: List<String>,

    @ColumnInfo(name = "recipe")
    val recipe: String,

    @ColumnInfo(name = "image_path")
    val imagePath: String
)