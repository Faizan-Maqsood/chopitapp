package com.example.chopitapp.ui.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.example.chopitapp.R
import com.example.chopitapp.databinding.ActivityHomeBinding
import com.example.chopitapp.ui.fragment.HomeFragment
import com.example.chopitapp.ui.fragment.PersonalProfileFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        //make status bar transparent
        window?.statusBarColor = Color.TRANSPARENT

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        listners()
        changeFragment(HomeFragment())
        /*recyclerMain()
        recyclerProfile()*/


    }
    private fun listners(){
        binding.apply {
            /*imageSearch.setOnClickListener{
                val intent = Intent(this@HomeActivity, SearchActivity::class.java)
                startActivity(intent)
            }
            buttonBack.setOnClickListener{
                val intent = Intent(this@HomeActivity, LoginActivity::class.java)
                startActivity(intent)
            }*/

            navigationBottom.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> {
                        changeFragment(HomeFragment())
                        //   supportActionBar?.title = "Home"
                        true
                    }
                    R.id.person -> {
                        changeFragment(PersonalProfileFragment())
                        true
                    }
                    else -> {
                        false
                    }
                }
            }
        }
    }

    /*private fun recyclerMain(){
        val data = ArrayList<ItemModel>()

        binding.recyclerview.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL,false)
        for(i in 1..10){
            data.add(ItemModel(R.drawable.cartoonmain,R.drawable.cartoonuper,R.drawable.cartoonlower))
        }

        val adapter = CustomAdapter(data)
        binding.recyclerview.adapter = adapter
    }

    private fun recyclerProfile(){
        val data = ArrayList<ItemProfile>()

        binding.recyclerProfile.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL,false)
        for(i in 1..10){
            data.add(ItemProfile(R.drawable.image))
        }

        val adapter = AdapterProfile(data)
        binding.recyclerProfile.adapter = adapter
    }*/

     private fun changeFragment(frag : Fragment) {
         val fragment = supportFragmentManager.beginTransaction()
         fragment.replace(R.id.fragment_container, frag).commit()
     }

}