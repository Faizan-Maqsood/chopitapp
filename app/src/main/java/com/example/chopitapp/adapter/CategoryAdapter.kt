package com.example.chopitapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.chopitapp.model.ItemModelCategory
import com.example.chopitapp.R
import com.example.chopitapp.interfaces.CallAddInterface
import com.example.chopitapp.interfaces.CallItemInterface

class CategoryAdapter(private val list : ArrayList<ItemModelCategory>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.image_category)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclercategory, parent,false)
             return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val itemModel = list[position]
        holder.image.setImageResource(itemModel.image)
    }

    override fun getItemCount(): Int {
       return list.size
    }
}