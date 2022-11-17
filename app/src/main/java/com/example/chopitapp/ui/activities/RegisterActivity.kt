package com.example.chopitapp.ui.activities

import android.content.Intent
import android.content.Intent.*
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.example.chopitapp.R
import com.example.chopitapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding
    private var isShowPassword : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        //make status bar transparent
        window?.statusBarColor = Color.TRANSPARENT

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listners()


    }

    private fun listners(){
        binding.apply {
            textLoginnow.setOnClickListener{
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            buttonContinue.setOnClickListener{
                val username : String = edittextUsername.text.toString()
                val email : String = edittextEmailRegister.text.toString()
                val password : String = edittextPasswordRegister.text.toString()
                if (username.trim().isEmpty()){
                    Toast.makeText(applicationContext,"Please enter username", Toast.LENGTH_SHORT).show()
                }
                else if(email.trim().isEmpty()){
                    Toast.makeText(applicationContext,"Please enter email", Toast.LENGTH_SHORT).show()
                }
                else if(password.trim().isEmpty()){
                    Toast.makeText(applicationContext,"Please enter password", Toast.LENGTH_SHORT).show()
                }
                else{
                    if (isValidEmail(email)){
                        val intent = Intent(this@RegisterActivity,PersonalInformationActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(applicationContext,"Email is not valid", Toast.LENGTH_SHORT).show()
                    }
                }

            }
            buttonBack.setOnClickListener{
                val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            iconVisibility.setOnClickListener {
                if (isShowPassword){
                    edittextPasswordRegister.transformationMethod = PasswordTransformationMethod()
                    iconVisibility.setImageResource(R.drawable.ic_outline_visibility_off_24)
                    edittextPasswordRegister.setSelection(edittextPasswordRegister.text.length)
                    isShowPassword = false
                }
                else{
                    edittextPasswordRegister.transformationMethod = null
                    iconVisibility.setImageResource(R.drawable.ic_outline_visibility_24)
                    edittextPasswordRegister.setSelection(edittextPasswordRegister.text.length)
                    isShowPassword = true
                }
            }
            iconEmail.setOnClickListener {
                edittextEmailRegister.setSelection(edittextEmailRegister.text.length)
            }
            iconPassword.setOnClickListener {
                edittextPasswordRegister.setSelection(edittextPasswordRegister.text.length)
            }
            iconUsername.setOnClickListener {
                edittextUsername.setSelection(edittextUsername.text.length)
            }
        }
    }
    private fun isValidEmail(message : String) : Boolean{
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(message).matches()
    }
}