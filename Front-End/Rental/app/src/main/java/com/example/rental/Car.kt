package com.example.rental

data class Car(val pk: Int,
               val marque: String,
               val modele: String,
               val iftaken: Boolean,
               val acceleration: String,
               val seat: Int,
               val x: Double,
               val y: Double,
               val price: Double)

data class CarList(val cars: List<Car>)