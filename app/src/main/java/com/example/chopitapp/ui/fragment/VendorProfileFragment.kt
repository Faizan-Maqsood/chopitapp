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
import com.example.chopitapp.adapter.AdapterVendor
import com.example.chopitapp.databinding.FragmentVendorProfileBinding
import com.example.chopitapp.interfaces.CallItemInterface
import com.example.chopitapp.model.ItemModelVendor


class VendorProfileFragment : Fragment() , CallItemInterface {
   private lateinit var binding : FragmentVendorProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVendorProfileBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listners()
        setAdapter()
    }
    private fun listners(){
        binding.apply {
            buttonBack.setOnClickListener{
                changeFragment(PostDetailFragment())
            }
            ivChat.setOnClickListener{
                changeFragment(ChatFragment())
            }
            tvItems.setOnClickListener {
                tvItems.setTextColor(Color.parseColor("#5446FF"))
                tvActivity.setTextColor(Color.WHITE)
                ivDesign.visibility = View.VISIBLE
                ivDot.visibility = View.VISIBLE
                ivDesignr.visibility = View.VISIBLE
                ivDesignActivity.visibility = View.GONE
                ivDotActivity.visibility = View.GONE
                ivDesignrActivity.visibility = View.GONE
            }
            tvActivity.setOnClickListener {
                tvItems.setTextColor(Color.WHITE)
                tvActivity.setTextColor(Color.parseColor("#5446FF"))
                ivDesignActivity.visibility = View.VISIBLE
                ivDotActivity.visibility = View.VISIBLE
                ivDesignrActivity.visibility = View.VISIBLE
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
    private fun setAdapter(){
        val data = ArrayList<ItemModelVendor>()
        binding.recyclervendor.layoutManager = GridLayoutManager(requireContext(), 2)
        for (i in 1..10){
            data.add(ItemModelVendor(R.drawable.cartoonlower))
        }

        val adapter = AdapterVendor(data,this)

        binding.recyclervendor.adapter = adapter
    }

    override fun onItemClick() {
       changeFragment(CheckOutFragment())
    }
}