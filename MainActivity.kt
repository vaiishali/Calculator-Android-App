package com.example.calculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      
         //this function CLEAR and add characters
        fun addChars(string: String, Clear: Boolean) {
 
           // setting if statement to determine if the input isEmpty "(!= NULL)"
            if(Output.text.isNotEmpty()){
                Input.text = ""
            }


            // if this is bool value set to true, it is visible
            // clear and then append or add to the empty string
            if (Clear) {
                Output.text = ""
                Input.append(string)
            } else {
                Input.append(Output.text)
                Input.append(string)
                Output.text = ""
            }
        }

        keyEquals.setOnClickListener {


                // casting vals as required 
                val expression = ExpressionBuilder(Input.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    Output.text = longResult.toString()
                else
                    Output.text = result.toString()

        }


        //setting onClick functions and adding these numbers to the calculator
        // canClear is set to TRUE, which can be cleared as Clear button is pressed
        keyOne.setOnClickListener {
            addChars("1", true)
        }
        keyTwo.setOnClickListener {
            addChars("2", true)
        }
        keyThree.setOnClickListener {
            addChars("3", true)
        }
        keyFour.setOnClickListener {
            addChars("4", true)
        }
        keyFive.setOnClickListener {
            addChars("5", true)
        }
        keySix.setOnClickListener {
            addChars("6", true)
        }
        keySeven.setOnClickListener {
            addChars("7", true)
        }
        keyEight.setOnClickListener {
            addChars("8", true)
        }
        keyNine.setOnClickListener {
            addChars("9", true)
        }
        keyZero.setOnClickListener {
            addChars("0", true)
        }
        keyDot.setOnClickListener {
            addChars(".", true)
        }


        //Adding Operators Key
        keyPlus.setOnClickListener {
            addChars("+", false)
        }
        keyMinus.setOnClickListener {
            addChars("-", false)
        }
        keyMul.setOnClickListener {
            addChars("*", false)
        }
        keyDivide.setOnClickListener {
            addChars("/", false)
        }


        // when clear key is pressed string is set to empty
        keyClear.setOnClickListener {
            Input.text = ""
            Output.text = ""
        }


       // this helps to delete inputs, which checks it is already empty or not
        keyBack.setOnClickListener {
            val string = Input.text.toString()
            if(string.isNotEmpty()){

                //if it’s not empty it takes the string and convert it into a substring then it deletes one    char as the button is pressed
                Input.text = string.substring(0,string.length-1)
            }
            Output.text = ""
        }
    }
}
}
