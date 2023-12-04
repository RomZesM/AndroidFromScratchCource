package com.example.homework_sandbox_week01

sealed class SealedClassTesting{
    class Banan(val weight : Int, val color : String) : SealedClassTesting()
    class Apple(val weight : Int, val color : String, val variety : String) : SealedClassTesting()
    class Potato(val weight : Int, val color : String, val variety : String) : SealedClassTesting()

}
