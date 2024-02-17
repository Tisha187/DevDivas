package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Ngodashboard : AppCompatActivity() {
    lateinit var bottomNav:BottomNavigationView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ngodashboard)
        bottomNav=findViewById<BottomNavigationView>(R.id.bottomnaviagationview)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.Child_details -> {
                    loadFragment(ChildFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.Applications->{
                    loadFragment(ApplicationFragment())
                    return@setOnItemSelectedListener  true

                }

                R.id.Profile-> {
                    loadFragment(NgoProfile())
                    return@setOnItemSelectedListener true
                }


                else -> false
            }
        }
    }


private  fun loadFragment(fragment: Fragment){
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.nav_host_fragment,fragment)
    transaction.addToBackStack(null)
    transaction.commit()
}


}