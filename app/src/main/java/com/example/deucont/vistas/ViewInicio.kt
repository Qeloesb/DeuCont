package com.example.deucont.vistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.deucont.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class ViewInicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_inicio)
        try {
            val bottomNavigationView = findViewById<BottomNavigationView>(R.id.botton_nav)
            bottomNavigationView.setOnItemSelectedListener { item ->

                when(item.itemId){
                    R.id.nav_home ->{
                        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,HomeFragment()).commit()
                        true
                    }
                    R.id.nav_add ->{
                        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,AddFragment()).commit()
                        true
                    }
                    else ->false
                }
            }
        }catch (e: Exception){
            Log.e("Error!", e.message.toString())
        }

    }
}