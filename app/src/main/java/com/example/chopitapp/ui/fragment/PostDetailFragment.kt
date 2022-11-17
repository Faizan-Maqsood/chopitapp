package com.example.chopitapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.chopitapp.R
import com.example.chopitapp.adapter.ViewPagerAdapter
import com.example.chopitapp.databinding.FragmentPostDetailBinding
import com.example.chopitapp.model.ItemViewPager


class PostDetailFragment : Fragment() {

private lateinit var binding : FragmentPostDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostDetailBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPager()
        listners()
    }
    private fun listners(){
        binding.apply {
            tvName.setOnClickListener{
                changeFragment(VendorProfileFragment())
            }
            buttonBack.setOnClickListener{
                changeFragment(HomeFragment())
            }
            ivMessage.setOnClickListener{
                changeFragment(ChatFragment())
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
    private fun setViewPager(){
        val data = ArrayList<ItemViewPager>()

            data.add(ItemViewPager(R.drawable.cartoonmain))
            data.add(ItemViewPager(R.drawable.viewpagers))
            data.add(ItemViewPager(R.drawable.cartoonuper))



        val adapter = ViewPagerAdapter(data)
        binding.viewpager.adapter = adapter

        binding.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        binding.ivFdots.setImageResource(R.drawable.ic_selecteddot)
                        binding.ivSdots.setImageResource(R.drawable.ic_unselecteddot)
                        binding.ivTdots.setImageResource(R.drawable.ic_unselecteddot)
                    }
                    1 -> {
                        binding.ivSdots.setImageResource(R.drawable.ic_selecteddot)
                        binding.ivFdots.setImageResource(R.drawable.ic_unselecteddot)
                        binding.ivTdots.setImageResource(R.drawable.ic_unselecteddot)
                    }
                    2 -> {
                        binding.ivTdots.setImageResource(R.drawable.ic_selecteddot)
                        binding.ivFdots.setImageResource(R.drawable.ic_unselecteddot)
                        binding.ivSdots.setImageResource(R.drawable.ic_unselecteddot)
                    }
                }
                super.onPageSelected(position)
            }
        })
    }
}