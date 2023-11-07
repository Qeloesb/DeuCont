package com.example.deucont

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.deucont.databinding.ActivityMainBinding
import com.example.deucont.vistas.ViewInicio

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btniniciarsesion.setOnClickListener {
            try {

                if (validateLogin()){
                    val intent = Intent (this, ViewInicio::class.java)
                    startActivity(intent)
                }
            }catch (e: Exception){
                Log.e("Error!", e.message.toString())
            }

        }
    }
    private fun validateLogin(): Boolean{
            var isValid = true
            with(binding){
                if (etUsername.text.toString().isBlank()){
                    isValid=false
                    tflUsername.error="Campo Requerido"
                }else{
                    tflUsername.error=null
                }
                if (etPassword.text.toString().isBlank()){
                    isValid=false
                    tflPassword.error="Campo Requerido"
                }else{
                    tflPassword.error=null
                }
            }
         return isValid
    }
}


