package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.databinding.ActivityNgoBinding

class NgoActivity : AppCompatActivity() {

    private val binding: ActivityNgoBinding by lazy {
        ActivityNgoBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            startActivity(Intent(this, Ngodashboard::class.java))
        }
    }
}