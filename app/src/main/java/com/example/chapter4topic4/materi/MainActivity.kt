package com.example.chapter4topic4.materi

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.chapter4topic4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("mhs", Context.MODE_PRIVATE)
        binding.btnSave.setOnClickListener {
            saveData()
            Toast.makeText(this, "SAVE DATA SUCCESS!", Toast.LENGTH_SHORT).show()
        }
        binding.btnView.setOnClickListener {
            viewData()
        }
        binding.btnClear.setOnClickListener {
            clearData()
        }
    }

    fun saveData(){
        var getNPM = binding.editNPM.text.toString()
        var getNama = binding.editNama.text.toString()

        var addData = sharedPref.edit()
        addData.putString("npm", getNPM)
        addData.putString("nama", getNama)
        addData.apply()
    }

    fun viewData(){
        binding.txtNPM.text =  "NPM  : "+sharedPref.getString("npm", "")
        binding.txtNama.text = "Nama : "+sharedPref.getString("nama", "")
    }

    fun clearData(){
        var prefEdit = sharedPref.edit()
        prefEdit.clear()
        prefEdit.apply()

        binding.txtNPM.setText("")
        binding.txtNama.setText("")
    }
}