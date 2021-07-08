package com.example.weathertactonexperiment

import android.media.MediaPlayer
import android.media.audiofx.HapticGenerator
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import java.io.File

class EstimationFragment2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.estimation_fragment2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.e2b1).setOnClickListener {
            var mediaPlayer = MediaPlayer.create(requireContext(), R.raw.ffmpeg200hz500ms)
            HapticGenerator.create(mediaPlayer.audioSessionId).enabled = true
            mediaPlayer.start()
        }

        view.findViewById<View>(R.id.e2b2).setOnClickListener {
            var mediaPlayer = MediaPlayer.create(requireContext(), R.raw.ffmpeg200hz100ms)
            HapticGenerator.create(mediaPlayer.audioSessionId).enabled = true
            mediaPlayer.start()
        }

        view.findViewById<View>(R.id.e2b3).setOnClickListener {
            var mediaPlayer = MediaPlayer.create(requireContext(), R.raw.ffmpeg200hz1000ms)
            HapticGenerator.create(mediaPlayer.audioSessionId).enabled = true
            mediaPlayer.start()
        }

        view.findViewById<View>(R.id.estimation2_submit_button).setOnClickListener {
            val downloadFolder = requireContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
            val editText = view.findViewById<EditText>(R.id.estimation2_editTextNumber)
            File(downloadFolder?.path + File.separator + "test2.txt").appendText(
                editText.text.toString() + "\n"
            )
        }

        view.findViewById<View>(R.id.estimation2_next_button).setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.estimation3_dest, null)
        )
    }
}