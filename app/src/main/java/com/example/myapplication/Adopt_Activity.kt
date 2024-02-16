package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
//import com.example.myapplication.fragments.about_us
import com.google.android.material.navigation.NavigationView

class Adopt_Activity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var sideDrawerLayout: NavigationView
    lateinit var buttondrawer: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adopt)

        drawerLayout = findViewById(R.id.my_drawer_layout)
        sideDrawerLayout = findViewById(R.id.navigationView)

//        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        buttondrawer = findViewById(R.id.sidebar)
        buttondrawer.setOnClickListener() {
            drawerLayout.open()
        }


//    sideDrawerLayout.setNavigationItemSelectedListener {
//        when (it.itemId) {
//            R.id.dashboard -> {
//                loadFragment(about_us())
//                return@setNavigationItemSelectedListener true
//            }
//
//            else -> false
//        }

}

//private  fun loadFragment(fragment: Fragment){
//    val transaction = supportFragmentManager.beginTransaction()
//    transaction.replace(R.id.container,fragment)
//    transaction.addToBackStack(null)
//    transaction.commit()
//}





}



