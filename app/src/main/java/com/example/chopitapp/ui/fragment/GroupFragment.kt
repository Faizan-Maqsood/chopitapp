package com.example.chopitapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chopitapp.model.ItemModelGroup
import com.example.chopitapp.R
import com.example.chopitapp.adapter.GroupAdapter
import com.example.chopitapp.databinding.FragmentGroupBinding


class GroupFragment : Fragment() {
  private lateinit var binding: FragmentGroupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGroupBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listners()
        setGroupAdapter()
    }
    private fun listners(){
        binding.apply {
            tvChat.setOnClickListener {
                changeFragment(ChatFragment())
            }
        }
    }
    private fun setGroupAdapter(){
        binding.recyclergroup.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,false)
        val data = ArrayList<ItemModelGroup>()

        for (i in 1..10){
            data.add(ItemModelGroup(R.drawable.image))
        }
        val adapter = GroupAdapter(data)
        binding.recyclergroup.adapter = adapter

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