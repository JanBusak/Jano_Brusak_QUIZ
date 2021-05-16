package com.example.jano_app

import android.security.keystore.StrongBoxUnavailableException

object Constants{
    const val USER_NAME: String= "user_name"
    const val TOTAL_QUESTIONS: String= "total_otazok"
    const val CORRECT_ANSWERS: String= "correct_answers"
    fun getOtazky(): ArrayList<Otazka>{
        val otazkaList = ArrayList<Otazka>()

        val otazka1 = Otazka(
            id = 1,
            otazka = "Ktorej krajine patrí táto vlajka?",
            R.drawable.ic_flag_of_argentina,
            optionOne = "Argentína",
            optionTwo = "Slovensko",
            optionThree = "Taliansko",
            optionFour = "Angora",
            correctAnswer = 1
        )
        otazkaList.add(otazka1)

        val otazka2 = Otazka(
            id = 2,
            otazka = "Ktorej krajine patrí táto vlajka?",
            R.drawable.ic_flag_of_australia,
            optionOne = "Argentína",
            optionTwo = "Australia",
            optionThree = "Grécko",
            optionFour = "Monako",
            correctAnswer = 2
        )
        otazkaList.add(otazka2)

        val otazka3 = Otazka(
            id = 3,
            otazka = "Ktorej krajine patrí táto vlajka?",
            R.drawable.ic_flag_of_belgium,
            optionOne = "Andora",
            optionTwo = "Ukrajina",
            optionThree = "Belgicko",
            optionFour = "Rusko",
            correctAnswer = 3
        )
        otazkaList.add(otazka3)

        val otazka4 = Otazka(
            id = 4,
            otazka = "Ktorej krajine patrí táto vlajka?",
            R.drawable.ic_flag_of_brazil,
            optionOne = "Brazília",
            optionTwo = "KOlumbia",
            optionThree = "Francúzko",
            optionFour = "Slovensko",
            correctAnswer = 1
        )
        otazkaList.add(otazka4)

        val otazka5 = Otazka(
            id = 5,
            otazka = "Ktorej krajine patrí táto vlajka?",
            R.drawable.ic_flag_of_denmark,
            optionOne = "Argentína",
            optionTwo = "Dánsko",
            optionThree = "Irsko",
            optionFour = "Rusko",
            correctAnswer = 2
        )
        otazkaList.add(otazka5)

        val otazka6 = Otazka(
            id = 6,
            otazka = "Ktorej krajine patrí táto vlajka?",
            R.drawable.ic_flag_of_fiji,
            optionOne = "Fiji",
            optionTwo = "Holansko",
            optionThree = "Gracko",
            optionFour = "Andora",
            correctAnswer = 1
        )
        otazkaList.add(otazka6)

        val otazka7 = Otazka(
            id = 7,
            otazka = "Ktorej krajine patrí táto vlajka?",
            R.drawable.ic_flag_of_germany,
            optionOne = "Argentína",
            optionTwo = "Nemecko",
            optionThree = "Italy",
            optionFour = "Australia",
            correctAnswer = 2
        )
        otazkaList.add(otazka7)

        val otazka8 = Otazka(
            id = 8,
            otazka = "Ktorej krajine patrí táto vlajka?",
            R.drawable.ic_flag_of_india,
            optionOne = "Argentína",
            optionTwo = "Slovakia",
            optionThree = "India",
            optionFour = "Australia",
            correctAnswer = 3
        )
        otazkaList.add(otazka8)

        val otazka9 = Otazka(
            id = 9,
            otazka = "Ktorej krajine patrí táto vlajka?",
            R.drawable.ic_flag_of_kuwait,
            optionOne = "Kuwait",
            optionTwo = "Slovakia",
            optionThree = "Italy",
            optionFour = "Australia",
            correctAnswer = 1
        )
        otazkaList.add(otazka9)

        val otazka10 = Otazka(
            id = 10,
            otazka = "Ktorej krajine patrí táto vlajka?",
            R.drawable.ic_flag_of_new_zealand,
            optionOne = "Argentína",
            optionTwo = "Slovakia",
            optionThree = "Italy",
            optionFour = "Nový Zeland",
            correctAnswer = 4
        )
        otazkaList.add(otazka10)

        return otazkaList
    }
}
