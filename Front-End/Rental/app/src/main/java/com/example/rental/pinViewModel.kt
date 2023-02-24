package com.example.rental

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class pinViewModel : ViewModel() {

    val pin = MutableLiveData<String>()
}