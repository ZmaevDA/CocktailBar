package ru.vsu.zmaev.cocktailbar.util

import androidx.room.TypeConverter

class StringListConverter {

    @TypeConverter
    fun fromStringToList(data: String): List<String> {
        return data.split(",").map { it.trim() }
    }

    @TypeConverter
    fun fromListToString(list: List<String>): String {
        return list.joinToString(",")
    }
}