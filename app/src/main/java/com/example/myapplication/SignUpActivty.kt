package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivitySignUpActivtyBinding
import com.example.myapplication.model.User
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import java.security.AuthProvider

class SignUpActivty : AppCompatActivity() {
private lateinit var auth:FirebaseAuth
private lateinit var email:String
private lateinit var password:String
private lateinit var name:String
private lateinit var db:DatabaseReference

    private val binding: ActivitySignUpActivtyBinding by lazy {
        ActivitySignUpActivtyBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth= Firebase.auth
        db=Firebase.database.reference


        binding.createBtn.setOnClickListener {
            email=binding.editTextTextEmailAddress2.text.toString().trim()
            password=binding.editTextTextPassword2.text.toString().trim()
            name=binding.organizationName.text.toString().trim()

            if(email.isBlank() || password.isBlank() || name.isBlank()) {
                Toast.makeText(this,"Fill all details", Toast.LENGTH_SHORT).show()
            }
            else {
                createAccount(email, password)
            }

        }
        binding.alreadyAccountBtn.setOnClickListener {
            val intent = Intent(this, Login_Activity::class.java)
            startActivity(intent)
        }
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this,"Account Created Successfully", Toast.LENGTH_SHORT).show()
                    val intent=Intent(this, Login_Activity::class.java)
                    saveUserData()
                    startActivity(intent)
                    finish()
                }
                else {
                    Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()

                }
            }
    }

    private fun saveUserData() {
        val user=User(name,email,password)
        val userId=FirebaseAuth.getInstance().currentUser!!.uid

        db.child("user").child(userId).setValue(user)
    }
}