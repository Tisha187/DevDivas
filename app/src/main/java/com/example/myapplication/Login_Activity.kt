package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.signin.SignInOptions
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database


class Login_Activity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    private lateinit var database:DatabaseReference
    private lateinit var email:String
    private lateinit var password:String
    private lateinit var googleSignInclient:GoogleSignInClient

    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val googleSignInOptions=GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        auth= Firebase.auth
        database=Firebase.database.reference
        googleSignInclient=GoogleSignIn.getClient(this,googleSignInOptions)
        binding.button2.setOnClickListener {
            val signIntent=googleSignInclient.signInIntent
                launcher.launch(signIntent)
        }


        binding.loginBtn.setOnClickListener {
            email=binding.editTextTextEmailAddress.text.toString().trim()
            password=binding.editTextTextPassword.text.toString().trim()
            if(email.isBlank() || password.isBlank()){
                Toast.makeText(this, "Please Enter the details", Toast.LENGTH_SHORT).show()
            }
            else{
                login(email,password)
            }

        }
        binding.registerBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivty::class.java)
            startActivity(intent)
        }

    }

    private fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    val user=auth.currentUser
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, Adopt_Activity::class.java))
                }
                else{
                    Toast.makeText(this, "please sign up first", Toast.LENGTH_SHORT).show()
                }

            }

    }



    private fun updateUI(currentuser: FirebaseUser?) {

        startActivity(Intent(this,Adopt_Activity::class.java))
        finish()

    }

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                if (task.isSuccessful) {
                    val account: GoogleSignInAccount = task.result
                    val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                    auth.signInWithCredential(credential)
                        .addOnCompleteListener { authTask ->
                            if (authTask.isSuccessful) {
                                Toast.makeText(
                                    this,
                                    "Successfully sign in with Google",
                                    Toast.LENGTH_SHORT
                                ).show()
                                updateUI(authTask.result?.user)
                                finish()
                            } else {
                                Toast.makeText(
                                    this,
                                    "Google: Sign In failed: ${authTask.exception}",
                                    Toast.LENGTH_SHORT
                                ).show()
                                Log.d("Account", "Authentication failed", task.exception)
                            }
                        }
                } else {
                    Toast.makeText(
                        this,
                        "Google: Sign In failed: ${task.exception}",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("Account", "Authentication failed", task.exception)
                }
            }
        }
}