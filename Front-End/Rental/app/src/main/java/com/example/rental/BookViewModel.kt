package com.example.rental

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookViewModel : ViewModel() {
    val id = MutableLiveData<String>()
    val marque = MutableLiveData<String>()
    val modele = MutableLiveData<String>()
    val price = MutableLiveData<String>()
    val pin = MutableLiveData<String>()
}