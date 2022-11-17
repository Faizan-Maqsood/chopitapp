package com.example.chopitapp.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chopitapp.R
import com.example.chopitapp.model.SelectionItemModel

class SelectionAdapter( private val list : ArrayList<SelectionItemModel>) : RecyclerView.Adapter<SelectionAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView : TextView = itemView.findViewById(R.id.text_trending)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_selection, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemModel = list[position]
        holder.textView.text = itemModel.text
        if(itemModel.isChecked){
            holder.textView.setBackgroundResource(R.drawable.selection_background)
            holder.textView.setTextColor(Color.WHITE)
        }
        else{
            holder.textView.setBackgroundResource(R.drawable.button_background_selectionchanges)
            holder.textView.setTextColor(Color.BLACK)
        }
        holder.textView.setOnClickListener{
           /* list.forEach {
                it.isChecked = false
            }*/
            val oldPosition = list.indexOfFirst { it.isChecked }
            list[oldPosition].isChecked = false
            itemModel.isChecked = !itemModel.isChecked
            notifyItemChanged(oldPosition)
            notifyItemChanged(position)
            //notifyItemRangeChanged(0,list.size-1)
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }
}