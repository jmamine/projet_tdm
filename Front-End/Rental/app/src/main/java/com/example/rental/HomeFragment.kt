package com.example.rental

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.*
import sendGetRequest
import kotlinx.coroutines.*
import com.example.rental.Car
import com.example.rental.CarList
import com.google.gson.JsonParser
//import sendLoginRequest

// import sendLoginRequest


class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val vm = MarqueModel()
        val view = requireActivity().findViewById<RecyclerView>(R.id.rvBrands)
        val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        view.layoutManager = layoutManager
        view.adapter = MarqueAdapter(requireContext(), vm.data)

        val vp = CarModel()
        val viewCars = requireActivity().findViewById<RecyclerView>(R.id.rvCars)
        val layoutManagerCars = GridLayoutManager(requireContext(), 2)
        viewCars.layoutManager = layoutManagerCars
        viewCars.adapter = CarAdapter(requireContext(), vp.data)


        //val hh = requireActivity().findViewById<TextView>(R.id.brand)
            //val response = sendGetRequest("http://localhost:8000/simple/")


     GlobalScope.launch(Dispatchers.IO) {GlobalScope.launch(Dispatchers.IO) {
             val response = sendGetRequest(" https://05ad-105-235-129-141.eu.ngrok.io/all_objects/")
            //val response = sendLoginRequest(" https://05ad-105-235-129-141.eu.ngrok.io/login/", "amine@amine.amine", "amine")

            //val gson = Gson()
            //val jsonString = response.substringAfter("=")
            //val jsonArray = JsonParser.parseString(response).asJsonArray
            //val jsonArray = JsonParser().parse(response).asJsonArray
            //val firstElement = jsonArray.get(0).asJsonObject
            //val jsonStringWithBraces = "{$response}"
            //val carList = gson.fromJson<CarList>(jsonArray, CarList::class.java)
            withContext(Dispatchers.Main) {
                // Update the UI with the result
                //Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show()
                val mine = response.toString()
                //val mine = carList.cars[1].modele
                //val mine = firstElement.get("iftaken").toString()

                Toast.makeText(context,   mine , Toast.LENGTH_LONG).show()

            }
        }
    }






}
}