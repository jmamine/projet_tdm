package com.example.rental

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment


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

        val user_data=requireActivity().intent.getStringExtra("email")
        Toast.makeText(requireActivity(),user_data, Toast.LENGTH_LONG).show()

        val bundle = Bundle()
        val car = arguments?.getSerializable("car") as Car

        if (car!=null) {
        Toast.makeText(requireActivity(),"car id "+car.pk.toString()+" car marque "+car.marque,Toast.LENGTH_LONG).show()
        }

        button.setOnClickListener {
            val showPopup = PopUpFragment()
            showPopup.show((activity as AppCompatActivity).supportFragmentManager, "showPopUp")
        }

        //val hh = requireActivity().findViewById<TextView>(R.id.brand)
        //val response = sendGetRequest("http://localhost:8000/simple/")









    }


}