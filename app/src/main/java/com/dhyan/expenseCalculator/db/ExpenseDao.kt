package com.dhyan.expenseCalculator.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.dhyan.expenseCalculator.models.MainModel

@Dao
interface ExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: MainModel) :Long
}