package ru.vsu.zmaev.cocktailbar.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ru.vsu.zmaev.cocktailbar.data.model.CocktailEntity

@Dao
abstract class CocktailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(cocktailEntity: CocktailEntity): Long

    @Update
    abstract suspend fun update(cocktailEntity: CocktailEntity)

    @Query("DELETE FROM cocktail WHERE id = :id")
    abstract suspend fun deleteById(id: Long)

    @Query("SELECT * FROM cocktail WHERE id = :id")
    abstract suspend fun getById(id: Long): CocktailEntity?

    @Query("SELECT * FROM cocktail ORDER BY id DESC")
    abstract suspend fun getAll(): List<CocktailEntity>
}