package com.example.myapplication.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDashboardfragmentBinding
import com.example.myapplication.databinding.FragmentFormBinding
import com.example.myapplication.model.formModel
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class formFragment : Fragment() {
    private var binding: FragmentFormBinding? = null
    private lateinit var firstName: String
    private lateinit var lastName: String
    private lateinit var gender: String
    private lateinit var email: String
    private lateinit var phone: String
    private lateinit var sharedPrefs: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFormBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPrefs = requireActivity().getPreferences(Context.MODE_PRIVATE)

        binding?.apply {
            nextbtn.setOnClickListener {
                saveData()
                findNavController().navigate(R.id.action_formFragment_to_secondform3)
            }
        }
    }

    private fun saveData() {
        firstName = binding?.firstnameinput?.text.toString().trim()
        lastName = binding?.lastnameinput?.text.toString().trim()
        gender = binding?.genderinput?.text.toString().trim()
        email = binding?.emailinput?.text.toString().trim()
        phone = binding?.phoneinput?.text.toString().trim()

        // Create a formModel object
        val formData = formModel(firstName, lastName, gender, email, phone)

        // Get reference to the "FormData" node in the Firebase Realtime Database
        val databaseReference = FirebaseDatabase.getInstance().getReference("FormData")

        // Push the form data to the database
        val key = databaseReference.push().key // Generates a unique key for the data
        if (key != null) {
            databaseReference.child(key).setValue(formData)

            // Save the key to shared preferences
            sharedPrefs.edit().putString("formDataKey", key).apply()
            sharedPrefs.edit().putString("firstName", firstName).apply()
            sharedPrefs.edit().putString("lastName", lastName).apply()
            sharedPrefs.edit().putString("gender",gender).apply()
            sharedPrefs.edit().putString("email", email).apply()
            sharedPrefs.edit().putString("phone", phone).apply()

        } else {
            // Handle the case where generating a key failed
        }
    }


}

