package com.example.mytask4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task4.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvsigneup.setOnClickListener{
            var intent = Intent(this, signup::class.java)
            startActivity(intent)
            finish()
        }
        binding.blogin.setOnClickListener{
            if (binding.inpetloginusername.text!!.isEmpty() ||binding.inpetloginpassword.text!!.isEmpty() ){
                if(binding.inpetloginusername.text!!.isEmpty()){
                binding.tvloginusername.text="you forgot to add your name"

            }else{
                    binding.tvloginusername.text=""

                };
                if (binding.inpetloginpassword.text!!.isEmpty()){
                binding.tvloginpassword.text="you forgot to add your Password"
            }else{
                    binding.tvloginpassword.text=""
                }
            }else{
            intent=Intent(this, todolist::class.java)
            startActivity(intent)
            finish()
            }
        }
        binding.tvfogotpassword.setOnClickListener{
            intent=Intent(this, forgotpassword::class.java)
            startActivity(intent)
            finish()
        }
    }
}