package com.dhyan.expenseCalculator.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "auto_table"
)
data class AutoModel (
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    var amount: Double,
    val date: String,
)
