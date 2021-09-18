package com.dhyan.expenseCalculator.ui.fragments.shop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dhyan.expenseCalculator.repository.ShopRepository

class ShopViewModelProviderFactory(private val shopRepository: ShopRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShopViewModel(shopRepository) as T
    }


}