package com.example.myapplication

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.myapplication.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {

    lateinit var binding: ActivityHomePageBinding
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        drawerLayout = binding.drawerLayout
        val navView = binding.navView

        binding.apply {
            toggle= ActionBarDrawerToggle(this@HomePage, drawerLayout,R.string.open, R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            val actionBar: ActionBar? = supportActionBar
            actionBar?.setDisplayHomeAsUpEnabled(true)


            navView.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.home->{
                        Toast.makeText(this@HomePage, "Home", Toast.LENGTH_SHORT).show()
                    }
                    R.id.profile->{
                        Toast.makeText(this@HomePage, "Profile", Toast.LENGTH_SHORT).show()
                    }
                    R.id.logout->{
                        Toast.makeText(this@HomePage, "LogOut", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}