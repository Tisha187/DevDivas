package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.Child_Adapter
import com.example.myapplication.R.id.ChildProfileRV

class ChildProfile : AppCompatActivity() {

    lateinit var mAdapter: Child_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child_profile2)

        val recyclerView : RecyclerView = findViewById(ChildProfileRV)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val name: MutableList<String> =  mutableListOf("nitin", "ananya", "meet","nitin", "ananya", "meet","nitin", "ananya", "meet")
        val ngoname: MutableList<String> = mutableListOf("ngo1", "ngo2", "ngo3","ngo1", "ngo2", "ngo3","ngo1", "ngo2", "ngo3")
        val gender: MutableList<String> = mutableListOf("male", "female", "male","male", "female", "male","male", "female", "male")


        mAdapter = Child_Adapter(name,ngoname,gender)

        recyclerView.adapter = mAdapter


    }
}