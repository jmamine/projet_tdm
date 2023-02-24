package com.example.rental

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
//import android.R





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
        val viewModel = ViewModelProvider(requireActivity()).get(BookViewModel::class.java)

//        val bundle = bundleOf("car" to data[position])


        // Add the data to the Bundle using a key-value pair

        // Add the data to the Bundle using a key-value pair


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
            viewModel.id.value = car.pk.toString()
            viewModel.marque.value = car.marque
            viewModel.modele.value = car.modele
            viewModel.price.value = car.price.toString()

//            val bundle = Bundle()
//            bundle.putString("id", car.pk.toString()) // Put anything what you want
//
//
//            val fragment2 = BookFragment()
//            fragment2.setArguments(bundle)

//            fragmentManager
//                ?.beginTransaction()
//                ?.replace(R.id.content, fragment2)
//                ?.commit()
//            var bundle = bundleOf("car" to car)

            view.findNavController().navigate(R.id.action_detailsFragment_to_bookFragment)
        }

    }


}