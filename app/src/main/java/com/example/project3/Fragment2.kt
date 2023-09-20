package com.example.project3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class Fragment2 : Fragment() {
    var difficulty = "easy"
    var operation = "+"
    var questions = 10


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment2, container, false)

        difficulty = arguments?.getString("difficulty").toString()
        operation = arguments?.getString("operation").toString()
        questions = arguments?.getInt("questions")?.toInt() ?: 10


        val endRoundButton = view.findViewById<Button>(R.id.endRoundButton)
        val num1 = view.findViewById<TextView>(R.id.num1)
        val num2 = view.findViewById<TextView>(R.id.num2)
        val operationText = view.findViewById<TextView>(R.id.operationText)
        val input = view.findViewById<EditText>(R.id.inputText)

        if (operation == "division") operationText.text = "/"
        if (operation == "addition") operationText.text = "+"
        if (operation == "subtraction") operationText.text = "-"
        if (operation == "multiplication") operationText.text = "*"

        num1.text = (1 until 10).random().toString()
        num2.text = (1 until 10).random().toString()








        endRoundButton.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_fragment2_to_fragment3)
        }
        return view
    }


}