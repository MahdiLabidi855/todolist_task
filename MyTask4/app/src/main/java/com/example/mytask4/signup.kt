package com.example.mytask4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task4.databinding.ActivitySignupBinding

class signup : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.appCompatButton.setOnClickListener{
            if(binding.signupmail.text!!.isEmpty()||
                binding.signupname.text!!.isEmpty()||
                binding.signuppassowrd.text!!.isEmpty()||
                binding.signupconfirmpassword.text!!.isEmpty()||
                !binding.checkBox.isChecked ||
                binding.signupconfirmpassword.text ==binding.signuppassowrd.text
                    ){
                if(binding.signupmail.text!!.isEmpty()){
                    binding.tvsigneupmail.text="you forgot to add your mail"

                }else{
                    binding.tvsigneupmail.text=""

                };
                if(binding.signupname.text!!.isEmpty()){
                    binding.tvsigneupname.text="you forgot to add your name"

                }else{
                    binding.tvsigneupname.text=""

                };
                if(binding.signuppassowrd.text!!.isEmpty()){
                    binding.tvsigneuppassword.text="you forgot to add your password"

                }else{
                    binding.tvsigneuppassword.text=""

                };
                if(binding.signupconfirmpassword.text!!.isEmpty()){
                    binding.tvsigneupconfirimpassword.text="you forgot to add the same password"

                }else if(binding.signupconfirmpassword.text.toString()!! != binding.signuppassowrd.text.toString()){
                    binding.tvsigneupconfirimpassword.text="  it is not the same password"
                    binding.tvsigneuppassword.text="  it is not the same password"

                }else{
                    binding.tvsigneupconfirimpassword.text=""

                };

                if(!binding.checkBox.isChecked){
                    binding.tvchebox.text="you forgot to read me"

                }else{
                    binding.tvchebox.text=""

                };
            }else {
                var intent = Intent(this, todolist::class.java)
                startActivity(intent)
                finish()
            }
        }
        binding.tvgologin.setOnClickListener{
            intent  =Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}