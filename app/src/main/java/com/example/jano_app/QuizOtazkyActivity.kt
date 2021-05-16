package com.example.jano_app

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_otazky.*

class QuizOtazkyActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int= 1
    private var mOtazkyList: ArrayList<Otazka>? = null
    private var mSelectedOptionPosition: Int= 0
    private var mCorrectAnswers: Int=0
    private var mUserName: String? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_otazky)
        mUserName= intent.getStringExtra(Constants.USER_NAME)



        mOtazkyList= Constants.getOtazky()
        setOtazka()
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)



    }
    private fun setOtazka(){

        val otazka= mOtazkyList!![mCurrentPosition-1]

        defaultOptionView()
        if(mCurrentPosition == mOtazkyList!!.size){
            btn_submit.text = "DOKONČIŤ"
        }else {
            btn_submit.text = "POTVRĎ"
        }

        progressBar.progress= mCurrentPosition
        tv_progress.text= "$mCurrentPosition" + "/" + progressBar.max

        tv_question.text= otazka!!.otazka
        iv_image.setImageResource(otazka.image)
        tv_option_one.text= otazka.optionOne
        tv_option_two.text= otazka.optionTwo
        tv_option_three.text= otazka.optionThree
        tv_option_four.text= otazka.optionFour

    }
        private fun defaultOptionView(){
            val option = ArrayList<TextView>()
        option.add(0,tv_option_one)
        option.add(1,tv_option_two)
        option.add(2,tv_option_three)
        option.add(3,tv_option_four)

        for (option in option){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )

        }
}

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, selectedOptionNum = 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, selectedOptionNum = 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, selectedOptionNum = 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, selectedOptionNum = 4)
            }
            R.id.btn_submit -> {
                if(mSelectedOptionPosition==0){
                    mCurrentPosition++
                when{
                    mCurrentPosition <= mOtazkyList!!.size -> {
                        setOtazka()
                    }else->  {

                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra(Constants.USER_NAME, mUserName)
                    intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                    intent.putExtra(Constants.TOTAL_QUESTIONS, mOtazkyList!!.size)
                    startActivity(intent)

                    }
                }
                }else {
                    val otazka = mOtazkyList?.get(mCurrentPosition -1)
                    if(otazka!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else {
                        mCorrectAnswers++
                    }
                    answerView(otazka.correctAnswer, R.drawable.correct_option_border_bg)
                    if(mCurrentPosition== mOtazkyList!!.size){
                        btn_submit.text= "DOKONČIŤ"
                    }else{
                        btn_submit.text= "ĎAlŠIA OTÁZKA"
                    }
                    mSelectedOptionPosition = 0
                }

            }

        }
    }
    private fun answerView (answer: Int, drawableView: Int){
        when (answer){
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }

        }
    }

    private fun selectedOptionView (tv: TextView, selectedOptionNum: Int){
        defaultOptionView()
        mSelectedOptionPosition=selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
}