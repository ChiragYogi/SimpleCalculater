package com.example.simplecaluculater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import com.example.simplecaluculater.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var inputTxt: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        inputTxt = binding.inputEdt
    }

    fun buttonClick(view: View) {

        when(view.id){

            R.id.buttonOne -> {
                numberClick("1")
            }
            R.id.buttonTwo -> {
                numberClick("2")
            }
            R.id.buttonThree -> {
                numberClick("3")
            }
            R.id.buttonFour -> {
                numberClick("4")
            }
            R.id.buttonFive -> {
                numberClick("5")
            }
            R.id.buttonSix -> {
                numberClick("6")
            }
            R.id.buttonSeven -> {
                numberClick("7")
            }
            R.id.buttonEight -> {
                numberClick("8")
            }
            R.id.buttonNine -> {
                numberClick("9")
            }
            R.id.buttonZero -> {
                numberClick("0")
            }
            R.id.buttonDoubleZero -> {
                numberClick("00")
            }
            R.id.buttonDot -> {
                numberClick(".")
            }
        }
    }

    private fun numberClick(numberClick: String) {

        val number = inputTxt.text.toString() + numberClick.toString()
        inputTxt.setText(number)
    }
}