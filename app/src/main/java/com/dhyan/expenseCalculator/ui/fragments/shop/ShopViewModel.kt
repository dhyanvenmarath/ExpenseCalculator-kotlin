package com.dhyan.expenseCalculator.ui.fragments.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dhyan.expenseCalculator.models.SumAuto
import com.dhyan.expenseCalculator.repository.ShopRepository

class ShopViewModel(
    private val shopRepository: ShopRepository
):ViewModel() {
    val totalAmountMutable: MutableLiveData<LiveData<SumAuto>> = MutableLiveData()

    init {
        getSumAmount()
    }
    private fun getSumAmount(){
        totalAmountMutable.postValue(shopRepository.getSumAmount())
    }

}