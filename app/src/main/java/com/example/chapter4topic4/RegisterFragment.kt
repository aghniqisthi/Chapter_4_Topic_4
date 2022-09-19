package com.example.chapter4topic4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.chapter4topic4.databinding.ActivityMainBinding
import com.example.chapter4topic4.databinding.FragmentRegisterBinding
import com.example.chapter4topic4.materi.DataMhsActivity
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

    lateinit var binding: FragmentRegisterBinding
    lateinit var sharedPref : SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = requireActivity().getSharedPreferences("dataUser", Context.MODE_PRIVATE)

        btnRegister.setOnClickListener {
            var getUsername = binding.editUserReg.text.toString()
            var getFullname = binding.editFullName.text.toString()
            var getPass = binding.editPassReg.text.toString()
            var getPassConf = binding.editPassConfReg.text.toString()

            if(getPass.equals(getPassConf)){
                var addUser = sharedPref.edit()
                addUser.putString("username", getUsername)
                addUser.putString("fullname", getFullname)
                addUser.putString("password", getPass)
                addUser.apply()
                Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment)
            }
            else Toast.makeText(context, "Password Invalid!", Toast.LENGTH_SHORT).show()
        }

        txtLogin.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment)
        }

    }

}