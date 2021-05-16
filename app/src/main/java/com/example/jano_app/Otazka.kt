package com.example.jano_app

data class Otazka (
    val id:Int,
    val otazka: String,
    val image: Int,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,
    val correctAnswer: Int
)