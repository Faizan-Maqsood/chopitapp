package com.example.chopitapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.chopitapp.R
import com.example.chopitapp.interfaces.CallItemInterface
import com.example.chopitapp.model.ItemModelVendor

class AdapterVendor(private val list : ArrayList<ItemModelVendor>, private val Itemclick : CallItemInterface): RecyclerView.Adapter<AdapterVendor.ViewHolder>() {

    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

        val image : ImageView = itemView.findViewById(R.id.imagevendor)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_vendorprofile, parent,false)
               return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemModel = list[position]
        holder.image.setImageResource(itemModel.image)
        holder.itemView.setOnClickListener{
           Itemclick.onItemClick()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}