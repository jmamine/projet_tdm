package com.example.rental

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class BookFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = requireActivity().findViewById<Button>(R.id.book_pay_button)

        button.setOnClickListener {
            val showPopup = PopUpFragment()
            showPopup.show((activity as AppCompatActivity).supportFragmentManager, "showPopUp")
        }

        //val hh = requireActivity().findViewById<TextView>(R.id.brand)
        //val response = sendGetRequest("http://localhost:8000/simple/")









    }


}