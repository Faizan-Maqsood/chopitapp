package com.example.chopitapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.chopitapp.R
import com.example.chopitapp.interfaces.CallItemInterface
import com.example.chopitapp.model.ItemModelChat

class ChatAdapter(private val list: ArrayList<ItemModelChat>, private val clickMessage : CallItemInterface):RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.image_profilechat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_chat, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemModel = list[position]
        holder.image.setImageResource(itemModel.image)
        holder.itemView.setOnClickListener{
            clickMessage.onItemClick()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}