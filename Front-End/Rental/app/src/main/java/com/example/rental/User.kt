package com.example.rental

data class User(val username: String,
                val email: String,
                val password: String,
                val ifLogged: Boolean,
                val phonenumber: String,
                val permis: Int,
                val credit_card: Int,
                val token: String,
)
