package com.example.rental

//import sendGetRequest
//import com.example.rental.CarList
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.*
import okio.IOException


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
        abdou()

////        val vp = CarModel()
//        val viewCars = requireActivity().findViewById<RecyclerView>(R.id.rvCars)
//        val layoutManagerCars = GridLayoutManager(requireContext(), 2)
//        viewCars.layoutManager = layoutManagerCars
//        viewCars.adapter = CarAdapter(requireContext(), vp.data)


        //val hh = requireActivity().findViewById<TextView>(R.id.brand)
        //val response = sendGetRequest("http://localhost:8000/simple/")


//     GlobalScope.launch(Dispatchers.IO) {GlobalScope.launch(Dispatchers.IO) {
//             //val response = sendGetRequest(" https://05ad-105-235-129-141.eu.ngrok.io/all_objects/")
//             val response = sendLoginRequest(" https://05ad-105-235-129-141.eu.ngrok.io/login/", "amine@amine.amine", "amine")
//
//            //val gson = Gson()
//            //val jsonString = response.substringAfter("=")
//            //val jsonArray = JsonParser.parseString(response).asJsonArray
//            //val jsonArray = JsonParser().parse(response).asJsonArray
//            //val firstElement = jsonArray.get(0).asJsonObject
//            //val jsonStringWithBraces = "{$response}"
//            //val carList = gson.fromJson<CarList>(jsonArray, CarList::class.java)
//            withContext(Dispatchers.Main) {
//                // Update the UI with the result
//                //Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show()
//                val mine = response.toString()
//                //val mine = carList.cars[1].modele
//                //val mine = firstElement.get("iftaken").toString()
//
//                Toast.makeText(context,   mine , Toast.LENGTH_LONG).show()
//
//            }
//        }
//    }






    }

    fun abdou(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitService.endpoint.getCar()
            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    val car = response.body()
                    if (car != null){

                        /* val adapter = MyAdapter(requireActivity(),car)
                         binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())
                         binding.recyclerView.adapter = adapter
                         */
                        val viewCars = requireActivity().findViewById<RecyclerView>(R.id.rvCars)
                        val layoutManagerCars = GridLayoutManager(requireContext(), 2)
                        viewCars.layoutManager = layoutManagerCars
                        viewCars.adapter = CarAdapter(requireContext(), car as ArrayList<Car>)

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

//        val url ="https://2f39-41-220-146-222.eu.ngrok.io/all_objects/"
//
//        val request = Request.Builder().url(url).build()
//        val client = OkHttpClient()
//        client.newCall(request).enqueue(object: Callback{
//            override fun onResponse(call: Call, response: Response) {
//                val body = response.body.toString()
//                println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"+body)
//                Handler(Looper.getMainLooper()).post(java.lang.Runnable {
//                    Toast.makeText(context,body,Toast.LENGTH_LONG).show()
//                })
//            }
//            override fun onFailure(call: Call, e: IOException) {
//                println("Failed to execute request")
//            }
//        })

//        GlobalScope.launch(Dispatchers.IO) {GlobalScope.launch(Dispatchers.IO) {
//            val response = sendGetRequest(" https://05ad-105-235-129-141.eu.ngrok.io/all_objects/")
//            println(response)
//            val gson = GsonBuilder().create()
////            val abdou = "{$response}"
//            val cars = gson.fromJson(response, CarList::class.java)
//
//            withContext(Dispatchers.Main) {
//                val viewCars = requireActivity().findViewById<RecyclerView>(R.id.rvCars)
//                val layoutManagerCars = GridLayoutManager(requireContext(), 2)
//                viewCars.layoutManager = layoutManagerCars
//                viewCars.adapter = CarAdapter(requireContext(), cars)
//            }
//
//
//
//
//        }
//        }
    }
}

data class CarList(val cars: List<Car>)