package com.example.rental

//import sendGetRequest
//import com.example.rental.CarList
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.coroutines.*
import okhttp3.*
import okio.IOException
import sendLoginRequest
import sendcarsRequest


// import sendLoginRequest


class NotifFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = "https://47e7-41-220-149-145.eu.ngrok.io/resrvation/"
        val user_data=requireActivity().intent.getStringExtra("email")


        if (user_data != null) {

            book(url, user_data)
        }


    }

    fun book(url: String, email: String){
        CoroutineScope(Dispatchers.IO).launch {
            val response = sendcarsRequest(url, email)
            val gson = Gson()
            val carList = gson.fromJson(response, Array<Book>::class.java)?.toList()
            withContext(Dispatchers.Main){
                if(carList!= null){
                    //val car = response.body()
                    if (carList!= null){

                        /* val adapter = MyAdapter(requireActivity(),car)
                         binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())
                         binding.recyclerView.adapter = adapter
                         */
                        val viewCars = requireActivity().findViewById<RecyclerView>(R.id.rvBooks)
                        val layoutManagerCars = GridLayoutManager(requireContext(), 2)
                        viewCars.layoutManager = layoutManagerCars
                        viewCars.adapter = BookAdapter(requireContext(), carList as ArrayList<Book>)

                    }
                    else{
                        Toast.makeText(requireActivity(), "error car is null!", Toast.LENGTH_SHORT).show()
                    }
                }
                else {
                    Toast.makeText(requireActivity(), "error try again", Toast.LENGTH_SHORT).show()
                }

            }
        }


    }

}

