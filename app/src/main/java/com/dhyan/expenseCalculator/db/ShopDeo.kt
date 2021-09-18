package com.dhyan.expenseCalculator.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dhyan.expenseCalculator.models.ShopModel
import com.dhyan.expenseCalculator.models.SumShop

@Dao
interface ShopDeo {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(shop:ShopModel):Long

    @Query("SELECT * FROM SHOP_TABLE")
    fun getAllShopData(): LiveData<List<ShopModel>>

    @Delete
    suspend fun deleteShopData(shop: ShopModel)

    @Query("SELECT SUM(amount) as total FROM shop_table")
    fun getTotalAmount():LiveData<SumShop>?

    @Query("SELECT * FROM shop_table WHERE previous_balance = (SELECT MAX(previous_balance) FROM shop_table) ")
    fun getPreviousAmount():LiveData<SumShop>?


}