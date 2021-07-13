package com.example.weathertactonexperiment

import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
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

        val downloadFolder = requireContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
        File(downloadFolder?.path + File.separator + "data.txt").appendText(
            "participant1" + "\n"
        )
        File(downloadFolder?.path + File.separator + "random.txt").appendText(
            "1" + "\n" + "2" + "\n" + "3" + "\n"
        )

        val button = view.findViewById<Button>(R.id.start_button)
        button?.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.estimation1_dest, null)
        )
    }
}