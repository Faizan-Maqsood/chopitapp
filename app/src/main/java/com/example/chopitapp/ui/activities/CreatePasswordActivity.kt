package com.example.chopitapp.ui.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.chopitapp.databinding.ActivityCreatePasswordBinding

class CreatePasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreatePasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        //make status bar transparent
        window?.statusBarColor = Color.TRANSPARENT

        binding = ActivityCreatePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listners()
    }

    private fun listners(){
        binding.apply {
            buttonReset.setOnClickListener{
                val newPassword : String = edittextNewpassword.text.toString()
                val confirmPassword : String = edittextConfirmpassword.text.toString()
                if (newPassword.trim().isEmpty()){
                    Toast.makeText(applicationContext, "Please enter password", Toast.LENGTH_SHORT).show()
                }
                else if (confirmPassword.trim().isEmpty()){
                    Toast.makeText(applicationContext, "Please enter password again", Toast.LENGTH_SHORT).show()
                }
                else{
                    if(newPassword == confirmPassword){
                        val intent = Intent(this@CreatePasswordActivity,AccountCreatedActivity::class.java)
                        intent.putExtra("text", "Password Changed!")
                        intent.putExtra("texts", "Your Password has been changed Successfully.")
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(applicationContext, "Password does not match", Toast.LENGTH_SHORT).show()
                    }
                }

            }
            buttonBack.setOnClickListener{
                val intent = Intent(this@CreatePasswordActivity, OTPPasswordVerificationActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}