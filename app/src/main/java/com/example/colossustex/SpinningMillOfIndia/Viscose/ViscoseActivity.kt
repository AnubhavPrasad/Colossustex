package com.example.colossustex.SpinningMillOfIndia.Viscose

import android.annotation.TargetApi
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v4.media.MediaBrowserCompat
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import com.example.colossustex.MainActivity
import com.example.colossustex.R
import com.example.colossustex.SpinningMillOfIndia.SpinningMillOfIndia

class ViscoseActivity : AppCompatActivity() {
    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viscose_activity)
        val sectionsPagerAdapter =
            SectionsPagerAdapter(
                this,
                supportFragmentManager
            )
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setSelectedTabIndicatorColor(Color.WHITE)
        tabs.setTabTextColors(getColor(R.color.tabunselected),Color.WHITE)
        tabs.setupWithViewPager(viewPager)
        //val fab: FloatingActionButton = findViewById(R.id.fab)
        val toolbar=findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.viscose_menu)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.home_id->{
                    val intent=Intent(applicationContext,MainActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    overridePendingTransition(R.anim.nav_default_enter_anim,R.anim.nav_default_exit_anim)
                }
            }
            true
        }
        /*fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}