package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentApplicationBinding
import com.example.myapplication.model.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ApplicationFragment : Fragment() {
    private var binding: FragmentApplicationBinding? = null
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = FirebaseDatabase.getInstance().reference
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentApplicationBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun fetchData() {
        // Assuming "yourReference" points to the specific node in your database
        database.child("User").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    val person = dataSnapshot.getValue(User::class.java)

                    // Now 'person' contains your data
                    updateUI(person)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("YourFragment", "Error getting data", databaseError.toException())
            }
        })
    }

    private fun updateUI(person: User?) {
        // Update your UI with the retrieved data
        if (person != null) {
            // Update UI components with person.parentName and person.spouseName
        } else {
            // Handle the case where data is not available
        }

    }
}