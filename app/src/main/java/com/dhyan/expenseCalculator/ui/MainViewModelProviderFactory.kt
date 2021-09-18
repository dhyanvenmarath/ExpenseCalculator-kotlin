package com.dhyan.expenseCalculator.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dhyan.expenseCalculator.repository.MainRepository

class MainViewModelProviderFactory (val newsRepository: MainRepository): ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(newsRepository)as T

    }

}