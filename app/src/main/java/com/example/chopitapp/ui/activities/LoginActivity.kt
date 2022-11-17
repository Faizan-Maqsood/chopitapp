package com.example.chopitapp.ui.activities


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chopitapp.R
import com.example.chopitapp.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private var isShowPassword : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        //make status bar transparent
        window?.statusBarColor = Color.TRANSPARENT

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listners()
    }
    private fun listners(){
        binding.apply {
            textRegisternow.setOnClickListener{
                val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(intent)
                finish()
            }
            textForgetpassword.setOnClickListener{
                val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
                startActivity(intent)
            }
            buttonBack.setOnClickListener{
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            buttonSignin.setOnClickListener{
                val email : String = edittextEmail.text.toString()
                val password : String = edittextPassword.text.toString()
                if (email.trim().isEmpty()){
                    Toast.makeText(applicationContext,"Please enter email", Toast.LENGTH_SHORT).show()
                }
                else if(password.trim().isEmpty()){
                    Toast.makeText(applicationContext,"Please enter password", Toast.LENGTH_SHORT).show()
                }
                else{
                    if(isValidEmail(email)){
                        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                        startActivity(intent)

                    }
                    else{
                        Toast.makeText(applicationContext,"Email is not valid", Toast.LENGTH_SHORT).show()
                    }

                }

            }
            iconVisibility.setOnClickListener {
                 if (isShowPassword){
                     edittextPassword.transformationMethod = PasswordTransformationMethod()
                     iconVisibility.setImageResource(R.drawable.ic_outline_visibility_off_24)
                     edittextPassword.setSelection(edittextPassword.text.length)
                     isShowPassword = false
                 }
                else{
                    edittextPassword.transformationMethod = null
                     iconVisibility.setImageResource(R.drawable.ic_outline_visibility_24)
                     edittextPassword.setSelection(edittextPassword.text.length)
                     isShowPassword = true
                }
            }
            iconEmail.setOnClickListener {
                edittextEmail.setSelection(edittextEmail.text.length)
            }
            iconPassword.setOnClickListener {
                edittextPassword.setSelection(edittextPassword.text.length)
            }

        }

    }
    private fun isValidEmail(message : String) : Boolean{
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(message).matches()
    }
}