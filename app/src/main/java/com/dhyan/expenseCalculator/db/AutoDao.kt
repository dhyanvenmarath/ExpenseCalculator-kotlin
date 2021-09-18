package com.dhyan.expenseCalculator.db

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.*
import com.dhyan.expenseCalculator.models.AutoModel
import com.dhyan.expenseCalculator.models.SumAuto


@Dao
interface AutoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(auto:AutoModel):Long

    @Query("SELECT * FROM AUTO_TABLE")
    fun getAllAutoData():LiveData<List<AutoModel>>

    @Delete
    suspend fun deleteAutoData(auto: AutoModel)


    @Query("SELECT SUM(amount) as total FROM auto_table")
    fun getSumAmount(): LiveData<SumAuto>?



//   @Query("SELECT SUM(amount) FROM auto_table")
//   suspend fun getSumAmount():Double


}