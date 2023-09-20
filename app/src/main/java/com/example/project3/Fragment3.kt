package com.example.project3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class Fragment3 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment3, container, false)
        val resetButton = view.findViewById<Button>(R.id.resetButton)

        resetButton.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_fragment3_to_fragment1)
        }
        return view
    }


}