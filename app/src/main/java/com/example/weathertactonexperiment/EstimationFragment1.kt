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

class EstimationFragment1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.estimation_fragment1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.e1b1).setOnClickListener {
            var mediaPlayer = MediaPlayer.create(requireContext(), R.raw.ffmpeg200hz100ms)
            HapticGenerator.create(mediaPlayer.audioSessionId).enabled = true
            mediaPlayer.start()
        }

        view.findViewById<View>(R.id.e1b2).setOnClickListener {
            var mediaPlayer = MediaPlayer.create(requireContext(), R.raw.ffmpeg200hz500ms)
            HapticGenerator.create(mediaPlayer.audioSessionId).enabled = true
            mediaPlayer.start()
        }

        view.findViewById<View>(R.id.e1b3).setOnClickListener {
            var mediaPlayer = MediaPlayer.create(requireContext(), R.raw.ffmpeg200hz1000ms)
            HapticGenerator.create(mediaPlayer.audioSessionId).enabled = true
            mediaPlayer.start()
        }

        view.findViewById<View>(R.id.estimation1_submit_button).setOnClickListener {
            val downloadFolder = requireContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
            val editText = view.findViewById<EditText>(R.id.estimation1_editTextNumber)
            File(downloadFolder?.path + File.separator + "test2.txt").appendText(
                editText.text.toString() + "\n"
            )
        }

        view.findViewById<View>(R.id.estimation1_next_button).setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.estimation2_dest, null)
        )
    }
}