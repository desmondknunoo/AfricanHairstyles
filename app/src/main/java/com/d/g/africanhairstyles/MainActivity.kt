package com.d.g.africanhairstyles

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ShareActionProvider
import androidx.core.view.MenuItemCompat
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {
    private var shareActionProvider: ShareActionProvider? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

/*    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        // Locate MenuItem with ShareActionProvider
        val menuItem: MenuItem = menu.findItem(R.id.share)
        menuItem.also { menuItem ->
            shareActionProvider = MenuItemCompat.getActionProvider(menuItem) as? ShareActionProvider
        }

        return true
    }*/
/*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                if (drawerLayout.isDrawerOpen(navView)){
                    drawerLayout.closeDrawer(navView)
                } else
                    drawerLayout.openDrawer(navView)

                return true
            }
            R.id.share -> {
                shareAppLink()
                return true
            }
            R.id.notification -> {
                startActivity<Notification>()
                return true
            }
            R.id.rate -> {
                rateApp()
                return true
            }
            R.id.contact -> {
                startActivity<ContactUs>()
                return true
            }
            R.id.about -> {
                startActivity<About>()
                return true
            }
            R.id.faqs -> {
                startActivity<FAQs>()
                return true
            }
            R.id.news -> {
                startActivity<News>()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }


    // Call to update the share intent
    private fun setShareIntent(shareIntent: Intent) {
        shareActionProvider?.setShareIntent(shareIntent)
    }


    private fun shareAppLink(){
        val shareIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(
                Intent.EXTRA_TEXT, "Check out NSS GH (National Service Scheme) app. " +
                        "I use it to access all NSS services without stress.\n\n" +
                        "Get it for free at https://play.google.com/store/apps/details?id=$packageName")
            type = "text/plain"
        }
        startActivity(shareIntent)
        setShareIntent(shareIntent)
    }

    private fun rateApp(){
        try {
            var playstoreuri1: Uri = Uri.parse("market://details?id=$packageName")
            //or you can add
            //var playstoreuri:Uri=Uri.parse("market://details?id=manigautam.app.myplaystoreratingapp")
            var playstoreIntent1 = Intent(Intent.ACTION_VIEW, playstoreuri1)
            startActivity(playstoreIntent1)
            //it genrate exception when devices do not have playstore
        }catch (exp:Exception){
            var playstoreuri2: Uri = Uri.parse("http://play.google.com/store/apps/details?id=$packageName")
            //var playstoreuri:Uri=Uri.parse("http://play.google.com/store/apps/details?id=manigautam.app.myplaystoreratingapp")
            var playstoreIntent2 = Intent(Intent.ACTION_VIEW, playstoreuri2)
            startActivity(playstoreIntent2)
        }
    }*/

    /* override fun onBackPressed() {
         exitDialog()
     }
    */


    /*private fun exitDialog(){
        val dialog = MaterialDialog.Builder(this).title("Do you want to Exit?")
            .positiveText("YES")
            .negativeText("NO")
            .onPositive { _, _ -> finish() }
            .onNegative { dialog, _ -> dialog.dismiss() }.build()

        dialog.show()
    }
*/

}














