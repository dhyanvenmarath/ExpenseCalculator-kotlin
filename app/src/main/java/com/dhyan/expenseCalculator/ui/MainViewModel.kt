package com.dhyan.expenseCalculator.ui

import androidx.lifecycle.ViewModel
import com.dhyan.expenseCalculator.repository.MainRepository

class MainViewModel(
    val newsRepository: MainRepository
    ):ViewModel() {
    fun getName()="Ram"
}