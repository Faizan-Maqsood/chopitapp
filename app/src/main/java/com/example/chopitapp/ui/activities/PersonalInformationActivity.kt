package com.example.chopitapp.ui.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.chopitapp.databinding.ActivityPersonalInformationBinding

class PersonalInformationActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPersonalInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        //make status bar transparent
        window?.statusBarColor = Color.TRANSPARENT

         binding = ActivityPersonalInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listners()
    }

    private fun listners(){
        binding.apply {
            buttonSubmit.setOnClickListener {
                val name : String = edittextName.text.toString()
                val address : String = edittextLocation.text.toString()
                val phone : String = edittextPhone.text.toString()
                val description : String = edittextDescription.text.toString()
                if (name.trim().isEmpty()){
                    Toast.makeText(applicationContext, "Please enter name!", Toast.LENGTH_SHORT).show()
                }
                else if(address.trim().isEmpty()){
                    Toast.makeText(applicationContext, "Please enter location!", Toast.LENGTH_SHORT).show()
                }
                else if(phone.trim().isEmpty()){
                    Toast.makeText(applicationContext, "Please enter phone number!", Toast.LENGTH_SHORT).show()
                }
                else if(description.trim().isEmpty()){
                    Toast.makeText(applicationContext, "Please enter description!", Toast.LENGTH_SHORT).show()
                }
                else{
                    val intent = Intent(this@PersonalInformationActivity, OTPVerificationActivity::class.java)
                    startActivity(intent)
                }


            }
            textLogin.setOnClickListener{
                val intent = Intent(this@PersonalInformationActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            buttonBack.setOnClickListener{
                val intent = Intent(this@PersonalInformationActivity, RegisterActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}