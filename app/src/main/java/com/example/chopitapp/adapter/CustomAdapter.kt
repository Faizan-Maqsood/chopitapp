package com.example.chopitapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chopitapp.interfaces.CallAddInterface
import com.example.chopitapp.R
import com.example.chopitapp.model.ItemModel

class CustomAdapter(private val list : ArrayList<ItemModel>, private val callAdd : CallAddInterface): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemModel = list[position]
        holder.imagemain.setImageResource(itemModel.imagemain)
        holder.imageuper.setImageResource(itemModel.imageu)
        holder.imagelower.setImageResource(itemModel.imagel)
        holder.tvBuyNow.setOnClickListener{
            callAdd.onAddClick()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class ViewHolder(Itemview : View): RecyclerView.ViewHolder(Itemview) {
        val imagemain : ImageView = Itemview.findViewById(R.id.imageviemain)
        val imageuper : ImageView = Itemview.findViewById(R.id.imageviemainu)
        val imagelower : ImageView = Itemview.findViewById(R.id.imageviemainl)
        val tvBuyNow : TextView = Itemview.findViewById(R.id.tv_buynow)

    }


}