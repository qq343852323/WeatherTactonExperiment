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
            val downloadFolder = requireContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
            File(downloadFolder?.path + File.separator + "data.txt").appendText(
                "participant1" + "\n"
            )
            File(downloadFolder?.path + File.separator + "random.txt").appendText(
                "1" + "\n" + "2" + "\n" + "3" + "\n"
            )
            findNavController().navigate(R.id.estimation_dest)
        }
    }
}