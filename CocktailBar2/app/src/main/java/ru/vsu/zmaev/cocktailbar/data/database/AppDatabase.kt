package ru.vsu.zmaev.cocktailbar.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.vsu.zmaev.cocktailbar.data.dao.CocktailDao
import ru.vsu.zmaev.cocktailbar.data.model.CocktailEntity
import ru.vsu.zmaev.cocktailbar.util.StringListConverter

@Database(
    version = 1,
    entities = [CocktailEntity::class]
)
@TypeConverters(StringListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        private var instance: AppDatabase? = null

        @Synchronized
        fun get(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java, "COCKTAIL_DATABASE"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }
    }

    abstract fun cocktailDao(): CocktailDao
}