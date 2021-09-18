package com.dhyan.expenseCalculator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dhyan.expenseCalculator.R
import com.dhyan.expenseCalculator.databinding.ActivityMainBinding
import com.dhyan.expenseCalculator.db.ExpenseDatabase
import com.dhyan.expenseCalculator.repository.MainRepository
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val newsRepository=MainRepository(ExpenseDatabase(this))
        val viewModelProviderFactory=MainViewModelProviderFactory(newsRepository)
        viewModel= ViewModelProvider(this,viewModelProviderFactory).get(MainViewModel::class.java)


        val navView: BottomNavigationView = binding.bottomNavigationView

        val navController = findNavController(R.id.mainNavHostFragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment, R.id.totalFragment, R.id.billFragment
            )

        )
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)

        navView.setupWithNavController(navController)
    }

}