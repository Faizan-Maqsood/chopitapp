package com.example.chopitapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.chopitapp.R
import com.example.chopitapp.model.ItemProfile

class AdapterProfile(private val list : ArrayList<ItemProfile>): RecyclerView.Adapter<AdapterProfile.ViewHolder>() {

    inner class ViewHolder(Itemview: View): RecyclerView.ViewHolder(Itemview){
        val iv_profile : ImageView = Itemview.findViewById(R.id.image_profile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_profile, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemModel = list[position]
        holder.iv_profile.setImageResource(itemModel.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}