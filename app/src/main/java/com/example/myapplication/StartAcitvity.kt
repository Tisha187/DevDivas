package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.databinding.ActivityStartAcitvityBinding

class StartAcitvity : AppCompatActivity() {

    private val binding: ActivityStartAcitvityBinding by lazy {
        ActivityStartAcitvityBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.adoptbtn.setOnClickListener {
            val intent = Intent(this, Login_Activity::class.java)
            startActivity(intent)
        }
        binding.childbtn.setOnClickListener {
            val intent=Intent(this,NgoRegister::class.java)
            startActivity(intent)
        }
    }
}