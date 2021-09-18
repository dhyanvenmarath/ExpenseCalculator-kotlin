package com.dhyan.expenseCalculator.repository

import com.dhyan.expenseCalculator.db.ExpenseDatabase
import com.dhyan.expenseCalculator.models.AutoModel

class AutoRepository(val db:ExpenseDatabase) {
    suspend fun insert(autoModel: AutoModel)=db.getAutoDao().insert(autoModel)
    fun getSavedAutoData()=db.getAutoDao().getAllAutoData()
    suspend fun deleteLastAutoData(autoModel: AutoModel)=db.getAutoDao().deleteAutoData(autoModel)
    fun getSumAmount()=db.getAutoDao().getSumAmount()
}