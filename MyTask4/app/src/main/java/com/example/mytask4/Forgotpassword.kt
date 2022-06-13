package com.example.mytask4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.task4.databinding.ActivityForgotpasswordBinding

class forgotpassword : AppCompatActivity() {
    private lateinit var binding: ActivityForgotpasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityForgotpasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.appCompatButton2.setOnClickListener{
            if (binding.fogotpasswordmail.text!!.isEmpty()){
                binding.textView8.text="Add your Mail"
            }else{
                binding.textView8.text="Mail sended to you check your archive please"
                Handler().postDelayed({
                    var intent = Intent(this, Login::class.java)
                    startActivity(intent)
                    finish()
                },5000)
            }
        }
        binding.exit.setOnClickListener{
            intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}