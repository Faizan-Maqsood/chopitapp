package com.example.chopitapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chopitapp.R
import com.example.chopitapp.adapter.CategoryAdapter
import com.example.chopitapp.databinding.FragmentCheckOutBinding
import com.example.chopitapp.model.ItemModelCategory


class CheckOutFragment : Fragment() {
 private lateinit var binding : FragmentCheckOutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCheckOutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listners()
        setCategoryAdapter()
    }

    private fun setCategoryAdapter(){
        val data = ArrayList<ItemModelCategory>()

        binding.recyclercategory.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,false)
        for (i in 1..10){
            data.add(ItemModelCategory(R.drawable.cartoonlower))
        }

        val adapter = CategoryAdapter(data)
        binding.recyclercategory.adapter = adapter

    }

    private fun listners(){
        binding.apply {
            buttonCheckout.setOnClickListener{
                changeFragment(PaymentFragment())
            }
            buttonBack.setOnClickListener{
                changeFragment(VendorProfileFragment())
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
}