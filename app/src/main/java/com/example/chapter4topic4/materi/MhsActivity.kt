package com.example.chapter4topic4.materi

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter4topic4.databinding.ActivityMhsBinding

class MhsActivity : AppCompatActivity() {

    lateinit var binding: ActivityMhsBinding
    lateinit var sharedPref : SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMhsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("username", Context.MODE_PRIVATE)
        binding.btnSend.setOnClickListener {
            saveData()
        }
    }

    fun saveData(){
        var getUser = binding.editUsername.text.toString()

        var addUser = sharedPref.edit()
        addUser.putString("username", getUser)
        addUser.apply()

        var pindah = Intent(this, DataMhsActivity::class.java)
        startActivity(pindah)
    }
}