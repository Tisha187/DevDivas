package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.databinding.ActivityNgoBinding
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class NgoActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var email:String
    private lateinit var password:String

    private val binding: ActivityNgoBinding by lazy {
        ActivityNgoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth= Firebase.auth
        database= Firebase.database.reference

        binding.loginBtn.setOnClickListener {
            email=binding.emailinput.text.toString().trim()
            password=binding.publishedYear.text.toString().trim()
            if(email.isBlank() || password.isBlank()){
                Toast.makeText(this, "Please Enter the details", Toast.LENGTH_SHORT).show()
            }
            else{
                login(email,password)
            }
        }
        binding.registerBtn.setOnClickListener {
            startActivity(Intent(this, NgoRegister::class.java))
        }
    }

    private fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    val ngo=auth.currentUser
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, Ngodashboard::class.java))
                }
                else{
                    Toast.makeText(this, "please sign up first", Toast.LENGTH_SHORT).show()
                }

            }

    }
}