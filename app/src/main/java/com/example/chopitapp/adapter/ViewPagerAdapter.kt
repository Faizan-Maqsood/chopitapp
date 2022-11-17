package com.example.chopitapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.chopitapp.R
import com.example.chopitapp.model.ItemViewPager

class ViewPagerAdapter(private val list : ArrayList<ItemViewPager>) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    inner class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){
        val imageview : ImageView = itemview.findViewById(R.id.imageviewslider)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewpager_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemModel = list[position]
        holder.imageview.setImageResource(itemModel.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}