package com.example.mytask4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.task4.databinding.ActivityTodolistBinding
import com.example.task4.R


class todolist : AppCompatActivity() {
    private lateinit var binding:ActivityTodolistBinding
    lateinit var toggle :ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityTodolistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCurrentFragment(notes())
        val drawer = findViewById<DrawerLayout>(R.id.drawerlayout)
        toggle = ActionBarDrawerToggle(this,drawer, R.string.Open, R.string.Close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.nav.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.myname -> Toast.makeText(this,"Mahdi",Toast.LENGTH_SHORT).show()
                R.id.myemail -> Toast.makeText(this,"labidimahdi855@gmail.com",Toast.LENGTH_SHORT).show()
                R.id.myphone -> Toast.makeText(this,"94138886",Toast.LENGTH_SHORT).show()
                R.id.mypassword -> Toast.makeText(this,"12345678",Toast.LENGTH_SHORT).show()
                R.id.itemnots ->{
                    val todoFragment = notes()
                    setCurrentFragment(todoFragment)
                    binding.drawerlayout.close()
                }
                R.id.logout -> {
                    val intent =Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)

    }
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.clContent, fragment)
            commit()
        }
}