package com.edu.udea.compumovil.gr0120201.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.edu.udea.compumovil.gr0120201.lab1.Lab1Activities.utils.Prefs


class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var prefs: Prefs
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        prefs = Prefs(applicationContext)

        setContentView(R.layout.activity_main)
        val appBarConfig= AppBarConfiguration.Builder(R.id.poiListFragment,R.id.poiListFragment)
            .build()
        setupActionBarWithNavController(
             findNavController(R.id.fragment),
            appBarConfig
        )
        if (prefs.getUserState(applicationContext)) {
            findNavController(R.id.fragment).navigate(R.id.action_loginFragment_to_poiListFragment)
        } else
            findNavController(R.id.fragment)


    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

  /*  private fun rout() {
        var nav: Unit // findNavController(R.id.fragment)
        if (prefs.getUserState(applicationContext)) {
            nav = findNavController(R.id.fragment).navigate(R.id.action_loginFragment_to_poiListFragment)
        } else
             nav = findNavController(R.id.poiListFragment)
        return nav
    }*/

    override fun onBackPressed() {
    }
}