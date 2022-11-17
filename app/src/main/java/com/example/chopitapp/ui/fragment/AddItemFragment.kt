package com.example.chopitapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.example.chopitapp.R
import com.example.chopitapp.databinding.FragmentAddItemBinding


class AddItemFragment : Fragment() {
    private lateinit var binding : FragmentAddItemBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddItemBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
                changeFragment(VendorProfileItem())
            }
            buttonAdd.setOnClickListener{
                val title : String = edittextTitle.text.toString()
                val description : String = edittextDescription.text.toString()
                val price : String = edittextPrice.text.toString()
                if (title.trim().isEmpty()){
                    Toast.makeText(requireContext(), "Please enter title", Toast.LENGTH_SHORT).show()
                }
                else if(description.trim().isEmpty()){
                    Toast.makeText(requireContext(), "Please enter description", Toast.LENGTH_SHORT).show()
                }
                else if(price.trim().isEmpty()){
                    Toast.makeText(requireContext(), "Please enter price", Toast.LENGTH_SHORT).show()
                }
                else{
                    changeFragment(SuccessFragment())
                }


            }
        }
    }


}