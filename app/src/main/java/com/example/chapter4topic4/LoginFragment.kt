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
import com.example.chapter4topic4.databinding.FragmentLoginBinding
import com.example.chapter4topic4.databinding.FragmentRegisterBinding
import com.example.chapter4topic4.materi.DataMhsActivity
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    lateinit var sharedPref : SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = requireActivity().getSharedPreferences("dataUser", Context.MODE_PRIVATE)

        btnLogin.setOnClickListener {
            //username dan password di login
            var inputUsername = binding.editUserLog.text.toString()
            var inputPass = binding.editPassLog.text.toString()

            //username dan password dalam database sharedpreferences
            var username = sharedPref.getString("username", "")
            var password = sharedPref.getString("password", "")

            //seleksi username = username di register atau ga. kalo iya, masuk ke home. kalo ga, toast suruh register
            if(inputUsername.equals("") || inputPass.equals("")){
                Toast.makeText(context, "Fill In Username and Password!", Toast.LENGTH_SHORT).show()
            }
            else {
                if(inputUsername.equals(username)){
                    if(inputPass.equals(password)){
                        Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)
                    }
                    else Toast.makeText(context, "Password Invalid!", Toast.LENGTH_SHORT).show()
                }
                else Toast.makeText(context, "Username Invalid!", Toast.LENGTH_SHORT).show()
            }
        }

        txtRegister.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
}