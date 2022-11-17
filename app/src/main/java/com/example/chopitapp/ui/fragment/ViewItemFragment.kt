package com.example.chopitapp.ui.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import com.example.chopitapp.R
import com.example.chopitapp.adapter.ViewItemAdapter
import com.example.chopitapp.databinding.FragmentViewItemBinding
import com.example.chopitapp.model.ViewItemModel


class ViewItemFragment : Fragment() {
    private lateinit var binding : FragmentViewItemBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewItemBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listners()
        setViewAdapter()
    }

    private fun listners (){
        binding.apply {
            buttonBack.setOnClickListener {
               changeFragment(AddItemFragment())
            }
            tvItems.setOnClickListener {
                tvItems.setTextColor(Color.parseColor("#5446FF"))
                tvInventory.setTextColor(Color.WHITE)
                ivDesign.visibility = View.VISIBLE
                ivDot.visibility = View.VISIBLE
                ivDesignr.visibility = View.VISIBLE
                ivDesignInventory.visibility = View.GONE
                ivDotInventory.visibility = View.GONE
                ivDesignrInventory.visibility = View.GONE
            }
            tvInventory.setOnClickListener {
                tvItems.setTextColor(Color.WHITE)
                tvInventory.setTextColor(Color.parseColor("#5446FF"))
                ivDesignInventory.visibility = View.VISIBLE
                ivDotInventory.visibility = View.VISIBLE
                ivDesignrInventory.visibility = View.VISIBLE
                ivDesign.visibility = View.GONE
                ivDot.visibility = View.GONE
                ivDesignr.visibility = View.GONE
            }
        }
    }
    private fun changeFragment(frag : Fragment) {
        val backstack : String = frag.javaClass.name
        val manager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentPopped: Boolean = manager.popBackStackImmediate(backstack, 0)
        if(!fragmentPopped) {
            val fragment = activity?.supportFragmentManager?.beginTransaction()
            fragment?.replace(R.id.fragment_container, frag)?.addToBackStack(backstack)?.commit()
        }
    }

    private fun setViewAdapter(){
        val data = ArrayList<ViewItemModel>()
        binding.recyclerviewitem.layoutManager = GridLayoutManager(requireContext(), 2)
        for (i in 1..10){
            data.add(ViewItemModel(R.drawable.cartoonlower))
        }

        val adapter = ViewItemAdapter(data)

        binding.recyclerviewitem.adapter = adapter
    }


}