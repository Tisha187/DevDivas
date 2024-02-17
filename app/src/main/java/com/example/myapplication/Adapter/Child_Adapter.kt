package com.example.myapplication.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class Child_Adapter(private val name: MutableList<String>,
                    private val ngoname: MutableList<String>,
                    private val gender: MutableList<String>) : RecyclerView.Adapter<ChildProfileViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildProfileViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_childprofile, parent, false)
        return ChildProfileViewHolder(view)
    }

    override fun getItemCount(): Int {
        return name.size
    }

    override fun onBindViewHolder(holder: ChildProfileViewHolder, position: Int) {
        holder.bind(name[position],ngoname[position],gender[position])
    }
}

class ChildProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    val image: ImageView = itemView.findViewById(R.id.childPhoto)
    val name: TextView = itemView.findViewById(R.id.Name)
    val ngoname: TextView = itemView.findViewById(R.id.ngoName)
    val gender: TextView = itemView.findViewById(R.id.gender)

    fun bind(nameText: String, s: String, s1: String) {
        name.text = nameText
        ngoname.text = s
        gender.text = s1

    }
}