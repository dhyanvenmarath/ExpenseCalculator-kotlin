package com.dhyan.expenseCalculator.db

import androidx.room.TypeConverter
import com.dhyan.expenseCalculator.models.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source):String{
        return source.name
    }
    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name,name)
    }
}