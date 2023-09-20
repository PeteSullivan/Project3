package com.example.project3

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class Fragment2 : Fragment() {
    var difficulty = "easy"
    var operation = "+"
    var questions = 10
    var correct = 0
    var incorrect = 0
    var number1 = 0
    var number2 = 0
    var answer = 0


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment2, container, false)

        /*
        take data from main screen and store it for use.
         */
        difficulty = arguments?.getString("difficulty").toString()
        operation = arguments?.getString("operation").toString()
        questions = arguments?.getInt("questions")?.toInt() ?: 10


        val scoreButton = view.findViewById<Button>(R.id.scoreButton)
        val num1 = view.findViewById<TextView>(R.id.num1)
        val num2 = view.findViewById<TextView>(R.id.num2)
        val operationText = view.findViewById<TextView>(R.id.operationText)
        val input = view.findViewById<EditText>(R.id.inputText)
        val done = view.findViewById<Button>(R.id.doneButton)

        operationText.text = operation


        /*
        set initial numbers
         */
        number1 = when (difficulty) {
            "easy" -> (1 until 10).random()
            "medium" -> (1 until 25).random()
            else -> (1 until 50).random()
        }
        number2 = when (difficulty) {
            "easy" -> (1 until 10).random()
            "medium" -> (1 until 25).random()
            else -> (1 until 50).random()
        }
        num1.text = number1.toString()
        num2.text = number2.toString()


        done.setOnClickListener {
            /*
            hitting the done button:
            1. calculates the correct answer
            2. checks if the user used the right answer and stores that internally/displays it
            3. if all questions are asked, move data to next screen and switch fragments.
               if not, generate new numbers and reset.
             */
            answer = when (operation) {
                "+" -> number1 + number2
                "-" -> number1 - number2
                "*" -> number1 * number2
                else -> (number1 / number2).toInt()
            }
            if (input.text.toString().equals(answer.toString())) {
                correct++
                scoreButton.text = "$correct questions correct"
            }
            else incorrect++


            if (incorrect + correct == questions) {
                var bundle = bundleOf("correct" to correct, "questions" to questions)
                view.findNavController().navigate(R.id.action_fragment2_to_fragment3, bundle)
            }
            else {
                number1 = when (difficulty) {
                    "easy" -> (1 until 10).random()
                    "medium" -> (1 until 25).random()
                    else -> (1 until 50).random()
                }
                number2 = when (difficulty) {
                    "easy" -> (1 until 10).random()
                    "medium" -> (1 until 25).random()
                    else -> (1 until 50).random()
                }
                num1.text = number1.toString()
                num2.text = number2.toString()
            }


        }



        return view
    }


}