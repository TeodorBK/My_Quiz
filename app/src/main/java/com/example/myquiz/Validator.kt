package com.example.myquiz

object Validator {

    fun validatorInput(amount : Int, desc : String) : Boolean {
        return !(amount <= 0 || desc.isEmpty())
    }
}