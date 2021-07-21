package com.example.weathertactonexperiment

import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import java.io.File

class StartFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.start_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val button = view.findViewById<Button>(R.id.start_training_button)
//        button?.setOnClickListener(
//            Navigation.createNavigateOnClickListener(R.id.training_dest, null)
//        )
        view.findViewById<Button>(R.id.start_training_button).setOnClickListener {
            findNavController().navigate(R.id.training_dest)
        }
    }
}