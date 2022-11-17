package com.example.chopitapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import com.example.chopitapp.R
import com.example.chopitapp.adapter.AdapterVendor
import com.example.chopitapp.databinding.FragmentPersonalProfileBinding
import com.example.chopitapp.interfaces.CallItemInterface
import com.example.chopitapp.model.ItemModelVendor
import com.example.chopitapp.ui.activities.HomeActivity


class PersonalProfileFragment : Fragment(), CallItemInterface {
private lateinit var binding : FragmentPersonalProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPersonalProfileBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        listners()
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
    private fun listners(){
        binding.apply {
            buttonBack.setOnClickListener{
                val intent = Intent(activity, HomeActivity::class.java)
                startActivity(intent)
            }
            tvBecomevendor.setOnClickListener{
                changeFragment(VendorProfileItem())
            }
        }
    }


    private fun setAdapter(){
        val data = ArrayList<ItemModelVendor>()
        binding.recyclervendor.layoutManager = GridLayoutManager(requireContext(), 2)
        for (i in 1..10){
            data.add(ItemModelVendor(R.drawable.cartoonlower))
        }

        val adapter = AdapterVendor(data, this)

        binding.recyclervendor.adapter = adapter
    }

    override fun onItemClick() {
       changeFragment(VendorProfileItem())
    }


}