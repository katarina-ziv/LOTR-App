package com.example.lotrapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.lotrapp.R
import com.example.lotrapp.databinding.ActivityMainBinding
import com.example.lotrapp.serviceLayer.Repository
import com.example.lotrapp.services.persistence.database.QuoteDatabase
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
   lateinit var toggle : ActionBarDrawerToggle
    lateinit var bottomNav : BottomNavigationView
    lateinit var drawerLayout : DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    lateinit var viewModel: MainViewModel
    private lateinit var repository: Repository
    private lateinit var db : QuoteDatabase



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = QuoteDatabase(this)
        repository = Repository(db)
        val viewModelProviderFactory = MainViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(MainViewModel::class.java)

        Log.i("MainView","onCreate MainView")

        val navView = binding.navView
        val headerView = navView.getHeaderView(0)
        val navUsername = headerView.findViewById<TextView>(R.id.username)
        navController = findNavController(R.id.navHostFragment)

        bottomNav = binding.bottomNavigationView
        drawerLayout = binding.drawerLayout
        appBarConfiguration = AppBarConfiguration(navController.graph,drawerLayout)
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)
        NavigationUI.setupWithNavController(binding.navView,navController)

        //shared preferences
        val sharedPrefs = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val username = sharedPrefs.getString("username", "")
        navUsername.text = username.toString()

        //bottom navigation
        setupBottomNavigation()

        //toggle
       toggle = ActionBarDrawerToggle(this,binding.drawerLayout,R.string.open, R.string.close)
       binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

    }

   override fun onOptionsItemSelected(item: MenuItem): Boolean {
       if(toggle.onOptionsItemSelected(item)){
          return true
       }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,appBarConfiguration)
    }


    private fun setupBottomNavigation() {
      bottomNav.setupWithNavController(navController)
    }
}