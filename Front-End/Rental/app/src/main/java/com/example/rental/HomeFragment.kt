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
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.*
import sendGetRequest
import kotlinx.coroutines.*


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
        getcar()

        val vm = MarqueModel()
        val view = requireActivity().findViewById<RecyclerView>(R.id.rvBrands)
        val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        view.layoutManager = layoutManager
        view.adapter = MarqueAdapter(requireContext(), vm.data)


        //val hh = requireActivity().findViewById<TextView>(R.id.brand)
            //val response = sendGetRequest("http://localhost:8000/simple/")









    }

    private fun getcar(){

        GlobalScope.launch(Dispatchers.IO) {GlobalScope.launch(Dispatchers.IO) {
            val response = sendGetRequest("https://0382-105-235-130-147.eu.ngrok.io/all_objects/")
            withContext(Dispatchers.Main) {
                // Update the UI with the result

                val viewCars = requireActivity().findViewById<RecyclerView>(R.id.rvCars)
                val layoutManagerCars = GridLayoutManager(requireContext(), 2)
                viewCars.layoutManager = layoutManagerCars
                viewCars.adapter = CarAdapter(requireContext(), response as ArrayList<Car>)
            }
        }





    }



}
}