package edu.msudenver.cs3013.project2_s24

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    //Declare variables for the drawer layout, navigation controller, and app bar configuration
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    //\
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //set up the navigation drawer
        drawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        //set up the navigation controller
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Setup the ActionBar with navController and DrawerLayout
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_about_ecosystem, R.id.nav_Join,
                R.id.nav_network, R.id.nav_mission, R.id.nav_donate,
                R.id.nav_contact, R.id.nav_resources
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Replace setupWithNavController with custom listener
        navView.setNavigationItemSelectedListener { menuItem ->
            onNavigationItemSelected(menuItem)
        }
    }
    // Handle navigation item selection returns true if the item is selected and false otherwise
    private fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        // Handle navigation view item clicks here. When clicked, navigate to the selected item.
        when (menuItem.itemId) {
            R.id.nav_home, R.id.nav_about_ecosystem, R.id.nav_Join,
            R.id.nav_network, R.id.nav_mission, R.id.nav_donate,
            R.id.nav_contact, R.id.nav_resources, R.id.nav_fun_stem_facts-> {
                // Clear the back stack up to the start destination
                navController.popBackStack(navController.graph.startDestinationId, false)
                // Navigate to the selected item
                navController.navigate(menuItem.itemId)
                // Close the drawer
                drawerLayout.closeDrawer(GravityCompat.START)
                return true
            }
        }
        return false
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    // Handle the back button press
    override fun onBackPressed() {
        // Close the drawer if it is open
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            // Close the drawer
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}