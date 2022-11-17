package com.example.chopitapp.ui.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.example.chopitapp.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var binding : ActivityForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        //make status bar transparent
        window?.statusBarColor = Color.TRANSPARENT

        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listeners()
    }
    private fun listeners() {
        binding.apply {
            buttonSendcode.setOnClickListener {
                val email : String = edittextEmail.text.toString()
                if (email.trim().isEmpty()){
                    Toast.makeText(applicationContext,"Please enter email", Toast.LENGTH_SHORT).show()
                }
                else{
                    if (isValidEmail(email)){
                        val intent = Intent(this@ForgotPasswordActivity, OTPPasswordVerificationActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(applicationContext,"Email is not valid", Toast.LENGTH_SHORT).show()
                    }

                }

            }
            textLogin.setOnClickListener{
                val intent = Intent(this@ForgotPasswordActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            buttonBack.setOnClickListener{
                val intent = Intent(this@ForgotPasswordActivity,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
    private fun isValidEmail(message : String) : Boolean{
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(message).matches()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@ForgotPasswordActivity, LoginActivity::class.java)
        startActivity(intent)
    }
}