package com.example.rental

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.edit
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        val email = findViewById<TextInputEditText>(R.id.em)
        val password = findViewById<TextInputEditText>(R.id.ps)
        val button = findViewById(R.id.login) as ImageView
        val hh : amine


        button.setOnClickListener {

            login(email.text.toString(), password.text.toString())

        }
    }

//    private fun login(emailH: String, passwordH: String) {
//        println("ggggggggggggggggggggggggggg" + emailH + passwordH)
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = RetrofitService.endpoint.sendLoginRequest(emailH, passwordH)
////            val response = RetrofitService.endpoint.login(emailH, passwordH)
//            println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"+response)
//            withContext(Dispatchers.Main){
//                if(response.isSuccessful) {
//
//                    val user = response.body()
//                    if (user!=null) {
//                        // put adapter here
//
////                        val pref = getSharedPreferences("users", MODE_PRIVATE)
////                        pref.edit {
////                            putString("username",user.username)
////                            putBoolean("connected",true)
////                        }
//
//                        println("hhhhhhhhhhhhhhhhhhhhhhhhhhhh"+user)
//                        val intent = Intent(this@LoginActivity,MainActivity::class.java)
//                        startActivity(intent)
//                        finish()
//
//                    } else {
//
//                        Toast.makeText(this@LoginActivity,"Email ou Mdp erroné", Toast.LENGTH_LONG).show()
//
//
//                    }
//
//                } else {
//
//                    //Toast.makeText(this@LoginActivity,"une erreur s'est produite",Toast.LENGTH_LONG).show()
//                    Toast.makeText(this@LoginActivity,response.toString(), Toast.LENGTH_LONG).show()
//                }
//
//
//            } // retourner vers le main thread ( programmation synchrone )
//        } // executer la méthode dans un autre thread. ( suspend ne s'execute pas ici )
//    }

    private fun login(phonenumber: String,password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response =  RetrofitService.endpoint.login(LoginCreds(phonenumber,password))
            withContext(Dispatchers.Main) {
                if(response.isSuccessful) {
                    val user = response.body()
//                    if(user!=null) {
//                        print("USERSIGNED IN "+user.fullname)
//                        val pref = getSharedPreferences("fileName", Context.MODE_PRIVATE)
//                        pref.edit {
//                            putInt("idUser",user.id)
//                            putString("userName", user.fullname)
//                            putString("phoneNumber",user.phonenumber)
//                            putBoolean("connected",true)
//                        }
                        println("username isssssss"+user.username)
                        val intent = Intent(this@LoginActivity,MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else {
                        Toast.makeText(this@LoginActivity,"Recheck Phone Number or Password ", Toast.LENGTH_SHORT).show()
                    }
                }
                else {
                    Toast.makeText(this@LoginActivity,response.toString(), Toast.LENGTH_LONG).show()
//                    Toast.makeText(this@signin,"There is an error", Toast.LENGTH_SHORT).show()
                }


            }

        }

    }





