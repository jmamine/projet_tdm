package com.example.rental


data class Book (val pk:Int,
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