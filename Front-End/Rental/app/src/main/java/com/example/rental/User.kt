package com.example.rental

data class User(val PK:Int,
                val username:String,
                val email :String,
                val password:String,
                val iflogged:Boolean,
                val phonenumber:String,
                val permis:Int,
                val credit_card:Int,
                val token:String)
    :java.io.Serializable




