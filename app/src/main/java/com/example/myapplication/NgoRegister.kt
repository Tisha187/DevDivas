package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityNgoRegisterBinding
import com.example.myapplication.model.NGOUser
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class NgoRegister : AppCompatActivity() {
    private lateinit var organizationName: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var publishedYear: String
    private lateinit var city: String
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    private val binding: ActivityNgoRegisterBinding by lazy {
        ActivityNgoRegisterBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = Firebase.auth
        database = Firebase.database.reference

        binding.registerBtn.setOnClickListener {

            organizationName = binding.organizationName.text.toString().trim()
            email = binding.emailinput.text.toString().trim()
            password = binding.password.text.toString().trim()
            publishedYear = binding.publishedYear.text.toString().trim()
            city = binding.City.text.toString().trim()

            if (email.isBlank() || password.isBlank() || organizationName.isBlank() || publishedYear.isBlank() || city.isBlank()) {
                Toast.makeText(this, "Fill all details", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Account", Toast.LENGTH_SHORT).show()
                createAccount(email, password)
            }
        }

        binding.loginBtn.setOnClickListener {
            startActivity(Intent(this, NgoActivity::class.java))
        }
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show()
                    saveUserData()
                    val intent = Intent(this, NgoActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Authentication failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun saveUserData() {
        val ngo = NGOUser(organizationName, email, password, publishedYear, city)
        val ngoId = FirebaseAuth.getInstance().currentUser!!.uid
        database.child("ngo").child(ngoId).setValue(ngo)
    }
}
