package com.example.chopitapp.ui.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chopitapp.databinding.ActivityOtpverificationBinding


class OTPVerificationActivity : AppCompatActivity() {
    private lateinit var binding : ActivityOtpverificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        //make status bar transparent
        window?.statusBarColor = Color.TRANSPARENT

        binding = ActivityOtpverificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listners()

    }

    private fun listners(){
        binding.apply {
            buttonConfirm.setOnClickListener{
                val otp1 : String = textOtp1.text.toString()
                val otp2 : String = textOtp2.text.toString()
                val otp3 : String = textOtp3.text.toString()
                val otp4 : String = textOtp4.text.toString()
                val otp5 : String = textOtp5.text.toString()
                if (otp1.trim().isEmpty() || otp2.trim().isEmpty() || otp3.trim().isEmpty() || otp4.trim().isEmpty() || otp5.trim().isEmpty()){
                    Toast.makeText(applicationContext,"OTP is not verified", Toast.LENGTH_SHORT).show()
                }
                else{
                    val intent = Intent(this@OTPVerificationActivity, AccountCreatedActivity::class.java)
                    intent.putExtra("text", "Account Created")
                    intent.putExtra("texts","Your account has been created successfully.")
                    startActivity(intent)
                }

            }
            buttonBack.setOnClickListener{
                val intent = Intent(this@OTPVerificationActivity, PersonalInformationActivity::class.java)
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
            textOtp4.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    if (textOtp1.text.toString().length === 1)
                    {
                        textOtp5.requestFocus()
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
}