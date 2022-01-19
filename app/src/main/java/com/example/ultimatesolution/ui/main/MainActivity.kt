package com.example.ultimatesolution.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ultimatesolution.R
import com.example.ultimatesolution.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.combine

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    public lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToogle: ActionBarDrawerToggle

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = this;
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        drawerLayout = binding.drawerLayout;

        val fragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = fragment.navController

        setupDrawerLayout()
//        setupActionBarWithNavController(findNavController(R.id.fragmentContainerView))
//
//        actionBarDrawerToogle = ActionBarDrawerToggle(
//            this,
//            binding.drawerLayout,
//            R.string.nav_open,
//            R.string.nav_close
//        )

//        // pass the Open and Close toggle for the drawer layout listener
//        // to toggle the button
//        binding.drawerLayout.addDrawerListener(actionBarDrawerToogle)
//        actionBarDrawerToogle.syncState()
//


    }

    fun setupDrawerLayout() {
        binding.navigationView.setupWithNavController(navController)
//        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
    }


    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    companion object {
        private var mainActivity: MainActivity? = null;


        fun getMainActivity(): MainActivity? {
            return mainActivity;
        }

    }


}