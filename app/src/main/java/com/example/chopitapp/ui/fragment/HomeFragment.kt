package com.example.chopitapp.ui.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chopitapp.R
import com.example.chopitapp.adapter.AdapterProfile
import com.example.chopitapp.adapter.CustomAdapter
import com.example.chopitapp.adapter.SelectionAdapter
import com.example.chopitapp.databinding.FragmentHomeBinding
import com.example.chopitapp.interfaces.CallAddInterface
import com.example.chopitapp.model.ItemModel
import com.example.chopitapp.model.ItemProfile
import com.example.chopitapp.model.SelectionItemModel
import com.example.chopitapp.ui.activities.LoginActivity


class HomeFragment : Fragment(), CallAddInterface {


    private lateinit var binding : FragmentHomeBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerMain()
        setSelectionAdapter()
        recyclerProfile()
        listners()
    }

    private fun listners(){
        binding.apply {
          imageSearch.setOnClickListener{
              changeFragment(SearchFragment())
          }
            buttonBack.setOnClickListener{
                val intent = Intent(activity, LoginActivity::class.java)
                startActivity(intent)
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
    private fun setSelectionAdapter(){
        val data = ArrayList<SelectionItemModel>()

        binding.recyclerselection.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)

        data.add(SelectionItemModel("Trending",true))
        data.add(SelectionItemModel("Popular"))
        data.add(SelectionItemModel("Recommended"))
        data.add(SelectionItemModel("Advanced"))
        data.add(SelectionItemModel("Recent"))

        val adapter = SelectionAdapter(data)
        binding.recyclerselection.adapter = adapter

    }

    private fun recyclerMain(){
        val data = ArrayList<ItemModel>()
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
        for(i in 1..10){
            data.add(ItemModel(R.drawable.cartoonmain,R.drawable.cartoonuper,R.drawable.cartoonlower))
        }

        val adapter = CustomAdapter(data,this)
        binding.recyclerview.adapter = adapter
    }

    private fun recyclerProfile(){
        val data = ArrayList<ItemProfile>()
        binding.recyclerProfile.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
        for(i in 1..10){
            data.add(ItemProfile(R.drawable.image))
        }
        val adapter = AdapterProfile(data)
        binding.recyclerProfile.adapter = adapter
    }
    override fun onAddClick(){
        changeFragment(PostDetailFragment())
    }
}