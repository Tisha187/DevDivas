package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentOfflineMeetBinding
import com.example.myapplication.databinding.FragmentSecondformBinding

class offlineMeetFragment : Fragment() {
 private var binding:FragmentOfflineMeetBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOfflineMeetBinding.inflate(inflater, container, false)
        return binding?.root
    }

}