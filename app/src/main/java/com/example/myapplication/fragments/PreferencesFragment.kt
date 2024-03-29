package com.example.myapplication.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.ChildProfile
import com.example.myapplication.Login_Activity
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDashboardfragmentBinding
import com.example.myapplication.databinding.FragmentPreferencesBinding


class PreferencesFragment : Fragment() {
    private var binding: FragmentPreferencesBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPreferencesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            val intent = Intent(requireContext(), ChildProfile::class.java)
            startActivity(intent)

        }
    }


}