package com.example.rental

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView


class DetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val vp = ViewModelProvider(requireActivity()).get(CarModel::class.java)
//        val cardView = requireView().findViewById<CardView>(R.id.details_capacity)
//        cardView.set = 2 // set the width of the stroke
//        cardView.strokeColor = ContextCompat.getColor(this, R.color.stroke_color)
        val car = arguments?.getSerializable("car") as Car


//        val position = arguments?.getInt("position")
        if (car != null ) {
//            val carImage= requireActivity().findViewById (R.id.details_car_img) as ImageView
//            carImage.setImageResource(car.pic)

            val carMarque= requireActivity().findViewById (R.id.details_car_marque) as TextView
            carMarque.text = car.marque

            val carModel= requireActivity().findViewById (R.id.details_car_modele) as TextView
            carModel.text = car.modele

            val carCapacity= requireActivity().findViewById (R.id.details_cap_value) as TextView
            carCapacity.text = car.seat.toString()

            val carAcceleration= requireActivity().findViewById (R.id.details_speed_value) as TextView
            carAcceleration.text = car.acceleration

            val carPrice= requireActivity().findViewById (R.id.details_price) as TextView
            carPrice.text = car.price.toString() + "$"

        }
//        if (position != null) {
//            val car = vp.data[position]

//            val carImage= requireActivity().findViewById (R.id.details_car_img) as ImageView
//            carImage.setImageResource(car.pic)
//
//            val carMarque= requireActivity().findViewById (R.id.details_car_marque) as TextView
//            carMarque.text = car.marque
//
//            val carModel= requireActivity().findViewById (R.id.details_car_modele) as TextView
//            carModel.text = car.modele
//
//            val carCapacity= requireActivity().findViewById (R.id.details_cap_value) as TextView
//            carCapacity.text = car.seat.toString()
//
//            val carAcceleration= requireActivity().findViewById (R.id.details_speed_value) as TextView
//            carAcceleration.text = car.acceleration
//
//            val carPrice= requireActivity().findViewById (R.id.details_price) as TextView
//            carPrice.text = car.price.toString()



//        }

        val book = requireActivity().findViewById<Button>(R.id.details_book_button)

        book.setOnClickListener {
            view.findNavController().navigate(R.id.action_detailsFragment_to_bookFragment)
        }

    }


}