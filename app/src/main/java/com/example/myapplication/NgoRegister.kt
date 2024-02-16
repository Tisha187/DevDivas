package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityNgoBinding
import com.example.myapplication.databinding.ActivityNgoRegisterBinding

class NgoRegister : AppCompatActivity() {
    private val binding: ActivityNgoRegisterBinding by lazy {
        ActivityNgoRegisterBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.registerBtn.setOnClickListener {
            startActivity(Intent(this, NgoActivity::class.java))
        }
        binding.loginBtn.setOnClickListener {
            startActivity(Intent(this, NgoActivity::class.java))
        }
    }
}