package com.example.homework_sandbox_week01.utils

sealed class SealedClassTesting{
    class Banan(val weight : Int, val color : String) : SealedClassTesting(){
        val variety = "Cavendish";
        //second constructor for instantiation object with default values
        constructor() : this (10, "undefined")
    }
    class Apple(val weight : Int, val color : String, val variety : String) : SealedClassTesting(){

        //create get method
        val varietyInfo : String
            get() = "Apple variety is $variety"
    }
    class Potato(weightParam : Int, val color : String, val variety : String) : SealedClassTesting(){
        //create set method
        var weight = weightParam
            set(value) {
                field = when{
                    value > 0 -> value
                    value < 0 -> 0
                    else -> value
                }
                println("Debug weight $weight $value",)
            }
    }

}
