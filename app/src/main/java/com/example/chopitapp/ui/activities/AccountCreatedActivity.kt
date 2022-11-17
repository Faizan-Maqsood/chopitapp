package com.example.chopitapp.ui.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.chopitapp.databinding.ActivityAccountCreatedBinding

class AccountCreatedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccountCreatedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        //make status bar transparent
        window?.statusBarColor = Color.TRANSPARENT

        binding = ActivityAccountCreatedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra("text")
        val detail = intent.getStringExtra("texts")
        binding.textAccountcreated.text = title
        binding.textDetailAccountcreated.text  = detail
        listners()
    }

    private fun listners(){
        binding.apply {
            buttonBacklogin.setOnClickListener{
                val intent = Intent(this@AccountCreatedActivity,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}