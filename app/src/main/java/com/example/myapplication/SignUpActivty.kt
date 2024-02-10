package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivitySignUpActivtyBinding

class SignUpActivty : AppCompatActivity() {

    private val binding: ActivitySignUpActivtyBinding by lazy {
        ActivitySignUpActivtyBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.createBtn.setOnClickListener {
            val intent = Intent(this, Adopt_Activity::class.java)
            startActivity(intent)
        }
        binding.alreadyAccountBtn.setOnClickListener {
            val intent = Intent(this, Login_Activity::class.java)
            startActivity(intent)
        }
    }
}