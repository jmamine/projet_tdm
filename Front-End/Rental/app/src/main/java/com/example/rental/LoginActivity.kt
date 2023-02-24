package com.example.rental

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.edit
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import sendLoginRequest

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        val email =findViewById<TextInputEditText>(R.id.email_login)
        val password =findViewById<TextInputEditText>(R.id.password_login)
        val button =findViewById<ImageView>(R.id.login)

        button.setOnClickListener {
            login(email.text.toString(),password.text.toString())
        }

    }
    fun login(emailh:String,passwordh:String){
        GlobalScope.launch(Dispatchers.IO) {
            GlobalScope.launch(Dispatchers.IO) {
            // val response = sendGetRequest(" https://05ad-105-235-129-141.eu.ngrok.io/all_objects/")
            val response = sendLoginRequest("https://47e7-41-220-149-145.eu.ngrok.io/login/", emailh, passwordh)
            //val jsonObject = JSONObject(response)
            //val pk = jsonObject.getInt("pk")
            val gson = Gson()
            //val user = gson.fromJson(response, User::class.java)
            val userList = gson.fromJson(response, Array<User>::class.java)?.toList()


            // val gson = GsonBuilder().create()
            //val jsonStringWithBraces = "{ \"result\": $response}"
            //val cars = gson.fromJson(jsonStringWithBraces, CarList::class.java)

            withContext(Dispatchers.Main) {
                //val viewCars = requireActivity().findViewById<RecyclerView>(R.id.rvCars)
                //val layoutManagerCars = GridLayoutManager(requireContext(), 2)
                //viewCars.layoutManager = layoutManagerCars
                if (userList != null) {


                    val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                    intent.putExtra("email",userList[0].email.toString())
                    startActivity(intent)

                } else {
                    Toast.makeText(this@LoginActivity,"kmlo_drahmk" ,Toast.LENGTH_LONG).show()
                    // handle the case where userList is null
                }
                //viewCars.adapter = CarAdapter(requireContext(), cars)

            }




        }
        }
    }
}