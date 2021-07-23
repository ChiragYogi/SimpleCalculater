package com.example.simplecaluculater

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.simplecaluculater.databinding.ActivityMainBinding
import javax.script.ScriptEngineManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var inputTxt: EditText
    private lateinit var resultTxt: EditText
    private var check = 0
    private lateinit var text:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        inputTxt = binding.inputEdt
        inputTxt.movementMethod = ScrollingMovementMethod()
        inputTxt.isActivated = true
        inputTxt.isPressed = true
        resultTxt = binding.resultEdt
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
            R.id.buttonDevide ->{
                divideClicked()
            }
            R.id.buttonMultiply ->{
                multiPlyClicked()
            }
            R.id.buttonPluse ->{
                plusClicked()
            }
            R.id.buttonMinus ->{
                minusClicked()
            }
            R.id.buttonRoot ->{
                rootClicked()
            }
            R.id.buttonClear ->{
                clearClicked()
            }
            R.id.buttonBack ->{
                backClicked()
            }
            R.id.buttonEqual ->{
                equalClicked()
            }
        }
    }

    private fun equalClicked() {
           text = resultTxt.text.toString()
            inputTxt.setText(text)
            resultTxt.text = null
    }

    private fun backClicked() {
        var backSpace: String

        if (inputTxt.text.isNotEmpty()){

            val stringBuilder =StringBuilder(inputTxt.text)
            val find = inputTxt.text.toString()
            val find2=find.last()

            if (find2.equals("+")||find2.equals("-")||find2.equals("×")||find2.equals("%")||find2.equals("/")){
                check -= 1
            }

            stringBuilder.deleteCharAt(inputTxt.text.length-1)
            backSpace = stringBuilder.toString()
            inputTxt.setText(backSpace)
            if (inputTxt.text.isNotEmpty()){
                result(backSpace)
            }else{
                Toast.makeText(this,"No more number to delete",Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun result(text: String) {

        val engine = ScriptEngineManager().getEngineByName("rhino")
           try {

               val result:Any = engine.eval(text)
               val main = result.toString()
                if (this.check ==0){
                    resultTxt.text = null
                }else{
                    resultTxt.setText(main)

                }
                }catch (e: Exception){
                    Toast.makeText(this,"$e",Toast.LENGTH_SHORT).show()
                }

    }

    private fun clearClicked() {
        inputTxt.text = null
        resultTxt.text = null
    }

    private fun rootClicked() {
        text = inputTxt.text.toString() + "%"
        inputTxt.setText(text)
        this.check += 1
    }

    private fun minusClicked() {
        text = inputTxt.text.toString() + "-"
        inputTxt.setText(text)
        this.check += 1
    }

    private fun plusClicked() {

        text = inputTxt.text.toString() + "+"
        inputTxt.setText(text)
        this.check += 1
    }

    private fun multiPlyClicked() {
        text = inputTxt.text.toString() + "*"
        inputTxt.setText(text)
        this.check += 1
    }

    private fun divideClicked() {
        text = inputTxt.text.toString() + "/"
        inputTxt.setText(text)
        this.check += 1
    }

    private fun numberClick(numberClick: String) {
        val number = inputTxt.text.toString() + numberClick
        inputTxt.setText(number)
        result(number)
    }
}