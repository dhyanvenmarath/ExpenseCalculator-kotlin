package com.dhyan.expenseCalculator.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "shop_table"
)
data class ShopModel (
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    val amount:Double,
    val date:String,
    val previous_balance:Double
)