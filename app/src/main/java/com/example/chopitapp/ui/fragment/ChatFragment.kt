package com.example.chopitapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chopitapp.R
import com.example.chopitapp.adapter.ChatAdapter
import com.example.chopitapp.databinding.FragmentChatBinding
import com.example.chopitapp.interfaces.CallItemInterface
import com.example.chopitapp.model.ItemModelChat


class ChatFragment : Fragment(), CallItemInterface {
private lateinit var binding: FragmentChatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listners()
        setChatAdapter()
    }
    private fun listners(){
        binding.apply {
            tvGroup.setOnClickListener {
                changeFragment(GroupFragment())
            }
        }
    }

    private fun setChatAdapter(){
        binding.recyclerchat.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,false)
        val data = ArrayList<ItemModelChat>()

        for (i in 1..10){
            data.add(ItemModelChat(R.drawable.image))
        }
        val adapter = ChatAdapter(data, this)
        binding.recyclerchat.adapter = adapter

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

    override fun onItemClick() {
        changeFragment(ChatViewFragment())
    }


}