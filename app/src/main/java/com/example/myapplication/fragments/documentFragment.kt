package com.example.myapplication.fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDocumentBinding
import com.google.firebase.storage.FirebaseStorage

class DocumentFragment : Fragment() {
    private var binding: FragmentDocumentBinding? = null
    private var aadharUri: Uri? = null
    private var itrUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDocumentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            Aadharbutton.setOnClickListener {
                pickImageAadhar.launch("image/*")
            }
            ITRbtn.setOnClickListener {
                pickImageITR.launch("image/*")
            }
            Donebtn.setOnClickListener {
                if (aadharUri != null && itrUri != null) {
                    findNavController().navigate(R.id.action_documentFragment_to_preferencesFragment)
                }
                else {
                    Toast.makeText(context, "Please upload both documents", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun uploadImage(uri: Uri?, documentType: String) {
        if (uri != null) {
            val storage = FirebaseStorage.getInstance().reference
            val imageRef = storage.child("document/${documentType}/${uri.lastPathSegment}.jpg")
            val uploadTask = imageRef.putFile(uri)
            uploadTask.addOnSuccessListener {
                Toast.makeText(context, "Image Uploaded Successfully", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(context, "Image Upload Failed", Toast.LENGTH_SHORT).show()
            }
        }
        else {
            Toast.makeText(context, "Please select an image", Toast.LENGTH_SHORT).show()
        }
    }
    private val pickImageAadhar =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            if (uri != null) {
                aadharUri = uri
                uploadImage(aadharUri, "aadhar")
            }
        }
    private val pickImageITR =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            if (uri != null) {
                itrUri = uri
                uploadImage(itrUri, "itr")
            }
        }

}
