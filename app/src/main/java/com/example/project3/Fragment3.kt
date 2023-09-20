package com.example.project3

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class Fragment3 : Fragment() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment3, container, false)
        val resetButton = view.findViewById<Button>(R.id.resetButton)
        val scoreText = view.findViewById<TextView>(R.id.scoreText)

        val correct = arguments?.getInt("correct")?.toInt() ?: 0
        val questions = arguments?.getInt("questions")?.toInt() ?: 0

        /*
        displays the user's score, then lets the user return to the menu screen.
         */
        scoreText.text = "You got $correct out of $questions correct!"

        resetButton.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_fragment3_to_fragment1)
        }
        return view
    }


}