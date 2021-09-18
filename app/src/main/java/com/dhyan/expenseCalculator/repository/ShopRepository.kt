package com.dhyan.expenseCalculator.repository

import com.dhyan.expenseCalculator.db.ExpenseDatabase

class ShopRepository(val db:ExpenseDatabase) {
    fun getSumAmount()=db.getAutoDao().getSumAmount()
}