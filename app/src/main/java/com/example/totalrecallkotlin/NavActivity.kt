package com.example.totalrecallkotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_nav.*

// 1: https://www.fandroid.info/17-android-bottom-navigation/
// 2: https://stackoverflow.com/questions/50502269/illegalstateexception-link-does-not-have-a-navcontroller-set
// 3: https://wajahatkarim.com/2020/01/bottom-navigation-jetpack-2/
class NavActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment // смотри ссылку 2
        val navController = navHostFragment.navController

        navView.setupWithNavController(navController)

        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_dashboard,
                R.id.blank3,
                R.id.blank1,
                R.id.blank2)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}