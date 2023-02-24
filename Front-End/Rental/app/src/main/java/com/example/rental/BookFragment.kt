package com.example.rental

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import sendreservationRequest
import java.text.SimpleDateFormat
import java.util.Calendar


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
        val pick_date = requireActivity().findViewById<EditText>(R.id.date_picker)
        val marque = requireActivity().findViewById<TextView>(R.id.book_marque)
        val modele = requireActivity().findViewById<TextView>(R.id.book_modele)
        val price = requireActivity().findViewById<TextView>(R.id.book_price)

        val viewModel = ViewModelProvider(requireActivity()).get(BookViewModel::class.java)
        val viewModelPin = ViewModelProvider(requireActivity()).get(pinViewModel::class.java)

        val user_data=requireActivity().intent.getStringExtra("email")
//        Toast.makeText(requireActivity(),user_data, Toast.LENGTH_LONG).show()
        val id = viewModel.id.value
        marque.text = viewModel.marque.value
        modele.text = viewModel.modele.value
        price.text = viewModel.price.value+"$"

        println("hhhhhhhhhhhhhhhhhhhh id is "+id)
        println("hhhhhhhhhhhhhhhhhhhh id is "+price.text)
        println("hhhhhhhhhhhhhhhhhhhh id is "+marque.text)
        println("hhhhhhhhhhhhhhhhhhhh id is "+modele.text)
        Toast.makeText(requireActivity(),"id is "+id,Toast.LENGTH_LONG).show()
//
//        pick_date.setOnClickListener {
//            val calendar = Calendar.getInstance()
//            val year = calendar.get(Calendar.YEAR)
//            val month = calendar.get(Calendar.MONTH)
//            val day = calendar.get(Calendar.DAY_OF_MONTH)
//
//
//
////            val datePickerDialog = DatePickerDialog(requireContext(), {_, selectedYear, selectedMonth, selectedDay ->})
//        }
         pick_date.setOnClickListener {
            val cal = Calendar.getInstance()
            val picker = DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, month)
                cal.set(Calendar.DAY_OF_MONTH, day)
                pick_date.setText(SimpleDateFormat("dd/MM/yyyy").format(cal.time))
            }
            DatePickerDialog(
                requireContext(),
                picker,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(
                    Calendar.DAY_OF_MONTH
                )
            ).show()

         }
//        val bundle = Bundle()
//        val car = arguments?.getSerializable("car") as Car

//        val bundle = this.arguments
//        println("slm slm slmslm ")
//
//        if (bundle != null) {
//            println("hhhhhhhhhhhhhhhh CAR ID iss "+bundle.getString("id",""))
////            Toast.makeText(requireActivity(),"car id "+bundle.getString("id",""),Toast.LENGTH_LONG).show()
//        }


        button.setOnClickListener {
            val date = pick_date.text.toString()
            println("THE DATE IS            fqdsqf "+date)

            GlobalScope.launch(Dispatchers.IO) {
                GlobalScope.launch(Dispatchers.IO) {
                     val pin = sendreservationRequest("https://47e7-41-220-149-145.eu.ngrok.io/resrvation/", id.toString(), user_data.toString(), date )
                     withContext(Dispatchers.Main) {
                         if (pin != null) {
                     println("pinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn " + pin)
                    Toast.makeText(requireActivity(),"the pin is "+pin, Toast.LENGTH_LONG).show()
                             viewModelPin.pin.value = pin
                             println("1  "+viewModelPin.pin.value)
                             val last = viewModelPin.pin.value
                             println("2  "+viewModelPin.pin.value)
                             //val showPopup = PopUpFragment()
                             //showPopup.show((activity as AppCompatActivity).supportFragmentManager, "showPopUp")
                             view.findNavController().navigate(R.id.action_bookFragment_to_notifFragment)



                         } else {Toast.makeText(requireActivity(),"KEMLO DRAHMEK QDFQSDF QSD F QSD FQSD", Toast.LENGTH_LONG).show()

                         }

        }

        //val hh = requireActivity().findViewById<TextView>(R.id.brand)
        //val response = sendGetRequest("http://localhost:8000/simple/")












}}
        }


}}