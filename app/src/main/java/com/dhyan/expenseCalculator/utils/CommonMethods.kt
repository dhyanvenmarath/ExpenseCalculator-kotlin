package com.dhyan.expenseCalculator.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.text.SimpleDateFormat
import java.util.*

class CommonMethods {

        @SuppressLint("SimpleDateFormat")
        private val getSimple = SimpleDateFormat("dd-MMM-yyyy hh:mm:ss")
        val currentDate: String = getSimple.format(Date())

companion object{
               fun hideKeyboard(view:View) {
                       val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                       imm.hideSoftInputFromWindow(view.windowToken, 0)
               }
}





}