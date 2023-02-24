package com.example.rental

//import sendGetRequest
//import com.example.rental.CarList
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.*
import okio.IOException


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


        book()



    }

    fun book(){
        CoroutineScope(Dispatchers.IO).launch {

//            val response = RetrofitService.endpoint.getCar()

            withContext(Dispatchers.Main){

                if(response.isSuccessful){
                    val book = response.body()

                    if (book != null){

                        val viewCars = requireActivity().findViewById<RecyclerView>(R.id.rvBooks)
                        val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
                        viewCars.layoutManager = layoutManager
                        viewCars.adapter = CarAdapter(requireContext(), book as ArrayList<Car>)

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

