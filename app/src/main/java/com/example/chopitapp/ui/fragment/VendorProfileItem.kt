package com.example.chopitapp.ui.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.chopitapp.R
import com.example.chopitapp.databinding.FragmentVendorProfileItemBinding


class VendorProfileItem : Fragment() {
    private lateinit var binding : FragmentVendorProfileItemBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        //make status bar transparent
        requireActivity().window?.statusBarColor = Color.TRANSPARENT
        binding = FragmentVendorProfileItemBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listners()
    }

    private fun listners(){
        binding.apply {
            buttonBack.setOnClickListener{
                changeFragment(PersonalProfileFragment())
            }
            tvAdd.setOnClickListener {
                changeFragment(AddItemFragment())
            }
        }
    }


}