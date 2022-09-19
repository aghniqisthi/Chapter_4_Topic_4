package com.example.chapter4topic4.materi

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter4topic4.databinding.ActivityDataMhsBinding

class DataMhsActivity : AppCompatActivity() {

    lateinit var binding : ActivityDataMhsBinding
    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataMhsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = this.getSharedPreferences("username", Context.MODE_PRIVATE)

        var getData = sharedPref.getString("username", "")
        binding.txtUsername.text = getData
    }
}