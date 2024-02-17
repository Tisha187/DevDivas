package com.example.myapplication.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDashboardfragmentBinding
import com.example.myapplication.databinding.FragmentFormBinding
import com.example.myapplication.databinding.FragmentSecondformBinding
import com.example.myapplication.model.formModel
import com.google.firebase.database.FirebaseDatabase

class secondform : Fragment() {
    private var binding: FragmentSecondformBinding? = null
    private lateinit var PartnerName: String
    private lateinit var PartnerDob: String
    private lateinit var Address: String
    private lateinit var Occupation: String
    private  var IsSingle: Boolean = false
    private  var IsMarried: Boolean = false
    private  var IsDivorced: Boolean = false
    private lateinit var sharedPrefs: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentSecondformBinding.inflate(inflater, container, false)
        return binding?.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPrefs = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val formDataKey = sharedPrefs.getString("formDataKey", null)
        val firstName = sharedPrefs.getString("firstName", null)
        val lastName = sharedPrefs.getString("lastName", null)
        val gender = sharedPrefs.getString("gender", null)
        val email = sharedPrefs.getString("email", null)
        val phone = sharedPrefs.getString("phone", null)

        binding?.apply {
            Submitbtn.setOnClickListener {
                if (formDataKey != null) {
                    updateData(formDataKey,firstName,lastName,gender,email,phone)
                }
                else {

                }
            }
        }

    }

    private fun updateData(formDataKey: String, firstName: String?, lastName: String?, gender: String?, email: String?, phone: String?) {
        PartnerName = binding?.partnerNameinput?.text.toString().trim()
        PartnerDob = binding?.partnerDOBinput?.text.toString().trim()
        Address = binding?.addressinput?.text.toString().trim()
        Occupation = binding?.occupationinput?.text.toString().trim()
        IsSingle = binding?.singleOption?.isChecked == true
        IsMarried = binding?.marriedOption?.isChecked == true
        IsDivorced = binding?.divorcedOption?.isChecked == true

        val formData = formModel(firstName, lastName, gender, email, phone, partnerName = PartnerName, partnerDob = PartnerDob, address = Address, occupation = Occupation, isSingle = IsSingle, isMarried = IsMarried, isDivorced = IsDivorced)
        val databaseReference = FirebaseDatabase.getInstance().getReference("FormData")
        databaseReference.child(formDataKey).setValue(formData)

    }
}