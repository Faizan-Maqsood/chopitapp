package com.example.chopitapp.ui.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.example.chopitapp.databinding.ActivityOtppasswordVerificationBinding

class OTPPasswordVerificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOtppasswordVerificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        //make status bar transparent
        window?.statusBarColor = Color.TRANSPARENT

        binding = ActivityOtppasswordVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listners()
    }
    private fun listners(){
        binding.apply {
            buttonVerify.setOnClickListener{
                val otp1 : String = textOtp1.text.toString()
                val otp2 : String = textOtp2.text.toString()
                val otp3 : String = textOtp3.text.toString()
                val otp4 : String = textOtp4.text.toString()
                if (otp1.trim().isEmpty() || otp2.trim().isEmpty() || otp3.trim().isEmpty() || otp4.trim().isEmpty()){
                    Toast.makeText(applicationContext,"OTP is not verified", Toast.LENGTH_SHORT).show()
                }
                else{
                    val intent = Intent(this@OTPPasswordVerificationActivity,CreatePasswordActivity::class.java)
                    intent.putExtra("text", "Account Created")
                    intent.putExtra("texts","Your account has been created successfully.")
                    startActivity(intent)
                }

            }
            buttonBack.setOnClickListener{
                val intent = Intent(this@OTPPasswordVerificationActivity, ForgotPasswordActivity::class.java)
                startActivity(intent)
                finish()
            }
            textOtp1.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    if (textOtp1.text.toString().length === 1)
                    {
                        textOtp2.requestFocus()
                    }
                }
                override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
                ) {
                }
                override fun afterTextChanged(s: Editable) {
                }

            })
            textOtp2.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    if (textOtp1.text.toString().length === 1)
                    {
                        textOtp3.requestFocus()
                    }
                }
                override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
                ) {
                }
                override fun afterTextChanged(s: Editable) {
                }

            })
            textOtp3.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    if (textOtp1.text.toString().length === 1)
                    {
                        textOtp4.requestFocus()
                    }
                }
                override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
                ) {
                }
                override fun afterTextChanged(s: Editable) {
                }

            })
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@OTPPasswordVerificationActivity, ForgotPasswordActivity::class.java)
        startActivity(intent)
    }
}