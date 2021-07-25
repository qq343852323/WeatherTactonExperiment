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

class BetweenTrainingEstimationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.between_training_estimation_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.more_training_button).setOnClickListener {
            findNavController().navigate(R.id.training_dest)
        }

        view.findViewById<Button>(R.id.start_experiment_button).setOnClickListener {
            val arr = Array(27) { it }
            arr.shuffle()
            val downloadFolder = requireContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
            for(i in 0..26){
                File(downloadFolder?.path + File.separator + "random.txt").appendText(
                    arr.get(i).toString() + "\n"
                )
            }
            findNavController().navigate(R.id.estimation_dest)
        }
    }
}