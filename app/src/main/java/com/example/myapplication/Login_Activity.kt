package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityLoginBinding


class Login_Activity : AppCompatActivity() {

    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.loginBtn.setOnClickListener {
            val intent = Intent(this, Adopt_Activity::class.java)
            startActivity(intent)
        }
        binding.registerBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivty::class.java)
            startActivity(intent)
        }

    }
}