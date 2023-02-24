package com.example.rental

//data class Car (val marque:String,
//                val image_marque:Int,
//                val modele:String,
//                val iftaken:Boolean,
//                val acceleration:String,
//                val seat:Float,
//                val x:Float,
//                val y:Float,
//                val pic:Int,
//                val price:Float,
//                val pin:Int,)
data class Car (val pk:Int,
                val marque:String,
                val modele:String,
                val iftaken:Boolean,
                val acceleration:String,
                val seat:Int,
                val x:Float,
                val y:Float,
                val price:Float,)
    :java.io.Serializable




// {"pk": 1, "marque": "marque1", "modele": "modele1", "iftaken": true, "acceleration": "200", "seat": 4, "x": 100.0, "y": 100.0, "price": 1000.0}                