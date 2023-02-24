package com.example.rental

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import org.w3c.dom.Text


class PopUpFragment : DialogFragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pop_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = requireActivity().findViewById<Button>(R.id.popup_button)

        button.setOnClickListener {
            view.findNavController().navigate(R.id.action_popUpFragment_to_notifFragment)

        }

//        val viewModel = ViewModelProvider(requireActivity()).get(pinViewModel::class.java)
//
//        val pin = requireActivity().findViewById<TextView>(R.id.pinn)
//
//        println("hhhhhhhhhhhhhhhhhhhhhhh pin pin  "+pin)
//
//        pin.text = viewModel.pin.value
    }


}