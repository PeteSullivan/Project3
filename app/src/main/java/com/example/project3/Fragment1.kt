package com.example.project3

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class Fragment1 : Fragment() {


    var difficulty = "easy"
    var operation = "+"
    var questions = 10

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment1, container, false)
        val startButton = view.findViewById<Button>(R.id.startButton)
        val resultsText = view.findViewById<TextView>(R.id.resultsText)

        val questionPlus = view.findViewById<Button>(R.id.questionPlus)
        val questionMinus = view.findViewById<Button>(R.id.questionMinus)
        val questionCount = view.findViewById<TextView>(R.id.questionCount)
        val easy = view.findViewById<RadioButton>(R.id.easyButton)
        val medium = view.findViewById<RadioButton>(R.id.mediumButton)
        val hard = view.findViewById<RadioButton>(R.id.hardButton)
        val addition = view.findViewById<RadioButton>(R.id.addButton)
        val multiplication = view.findViewById<RadioButton>(R.id.multiplyButton)
        val subtraction = view.findViewById<RadioButton>(R.id.subtractButton)
        val division = view.findViewById<RadioButton>(R.id.divideButton)


        /*
        checks for a bundle. if there is one, add the results text on the fragment.
        if not, leave the text blank.
         */
        val correctLastTime = arguments?.getInt("correct")?.toInt() ?: 0
        val questionsLastTime = arguments?.getInt("questions")?.toInt() ?: 0
        val operationLastTime = arguments?.getString("operation")
        if (questionsLastTime != 0) {
            var str = "You got " + correctLastTime.toString() + " out of " + questionsLastTime.toString() + " correct in "
            str = when (operationLastTime) {
                "+" -> str + "addition. "
                "-" -> str + "subtraction. "
                "*" -> str + "multiplication. "
                else -> str + "division. "
            }

            if (correctLastTime.toDouble() / questionsLastTime.toDouble() < 0.8) {
                resultsText.text = str + "You need to practice more!"
                resultsText.setTextColor(Color.parseColor("#ff0000"))
            } else {
                resultsText.text = str + "Good work!"
                resultsText.setTextColor(Color.parseColor("#5A5A5A"))
            }
        }


        /*
        buttons change display and internal data storage to be passed
         */
        questionPlus.setOnClickListener {
            var temp = questionCount.text.toString().toInt() + 1
            questionCount.text = temp.toString()
            questions += 1
        }
        questionMinus.setOnClickListener {
            var temp = questionCount.text.toString().toInt() - 1
            if (temp != -1) questionCount.text = temp.toString()
            questions -= 1
        }
        easy.setOnClickListener { difficulty = "easy" }
        medium.setOnClickListener { difficulty = "medium" }
        hard.setOnClickListener { difficulty = "hard" }
        addition.setOnClickListener { operation = "+" }
        multiplication.setOnClickListener { operation = "*" }
        subtraction.setOnClickListener { operation = "-" }
        division.setOnClickListener { operation = "/" }


        /*
        bundle the main screen data and pass it to the next fragment
         */
        startButton.setOnClickListener {
            val bundle = bundleOf("difficulty" to difficulty, "operation" to operation, "questions" to questions)
            view.findNavController()
                .navigate(R.id.action_fragment1_to_fragment2, bundle)
        }
        return view
    }


}