package com.example.weathertactonexperiment

import android.media.MediaPlayer
import android.media.audiofx.HapticGenerator
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import org.w3c.dom.Text
import java.io.File

class EstimationFragment1 : Fragment() {

//    var v1: Int = 9

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
            var hapticGenerator = HapticGenerator.create(mediaPlayer.audioSessionId)
            hapticGenerator.enabled = true
            mediaPlayer.start()
            mediaPlayer.setOnCompletionListener {
//                hapticGenerator.close()
//                hapticGenerator.release()
                mediaPlayer?.release()
                mediaPlayer = null
            }
        }

        view.findViewById<View>(R.id.e1b2).setOnClickListener {
            var mediaPlayer = MediaPlayer.create(requireContext(), R.raw.ffmpeg200hz500ms)
            var hapticGenerator = HapticGenerator.create(mediaPlayer.audioSessionId)
            hapticGenerator.enabled = true
            mediaPlayer.start()
            mediaPlayer.setOnCompletionListener {
//                hapticGenerator.close()
//                hapticGenerator.release()
                mediaPlayer?.release()
                mediaPlayer = null
            }
        }

        view.findViewById<View>(R.id.e1b3).setOnClickListener {
            var mediaPlayer = MediaPlayer.create(requireContext(), R.raw.ffmpeg200hz1000ms)
            var hapticGenerator = HapticGenerator.create(mediaPlayer.audioSessionId)
            hapticGenerator.enabled = true
            mediaPlayer.start()
            mediaPlayer.setOnCompletionListener {
//                hapticGenerator.close()
//                hapticGenerator.release()
                mediaPlayer?.release()
                mediaPlayer = null
            }
        }

//        view.findViewById<TextView>(R.id.textView).text = v1.toString()
//
//        val levels = arrayOf("High", "Medium", "Low")
//        val spinner: Spinner = view.findViewById(R.id.spinner)
//
//        val arrayAdapter = ArrayAdapter(activity.baseContext, android.R.layout.simple_spinner_item, levels)
//        spinner.adapter = arrayAdapter
//        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                v1 = p2
//                view.findViewById<TextView>(R.id.textView).text = v1.toString()
//                Log.d("v1", v1.toString())
//            }

//            override fun onNothingSelected(p0: AdapterView<*>?) {
//                    Toast.makeText(requireContext(), v1.toString(), Toast.LENGTH_SHORT).show()
//                Log.d("v1", v1.toString())
//                view.findViewById<TextView>(R.id.textView).text = v1.toString()
//            }
//        }

//        ArrayAdapter.createFromResource(
//            requireContext(),
//            R.array.levels_array,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            spinner.adapter = adapter
//            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                    v1 = p2
//                    Log.d("v1", v1.toString())
//                }
//
//                override fun onNothingSelected(p0: AdapterView<*>?) {
////                    Toast.makeText(requireContext(), v1.toString(), Toast.LENGTH_SHORT).show()
//                    Log.d("v1", v1.toString())
//                }
//            }
//        }

        view.findViewById<View>(R.id.estimation1_submit_button).setOnClickListener {
            val downloadFolder = requireContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
            val editText = view.findViewById<EditText>(R.id.estimation1_editTextNumber)
            File(downloadFolder?.path + File.separator + "test10.txt").appendText(
                editText.text.toString() + "\n"
            )
//            if(!editText.text.toString().equals("123") &&
//                !editText.text.toString().equals("132") &&
//                !editText.text.toString().equals("213") &&
//                !editText.text.toString().equals("231") &&
//                !editText.text.toString().equals("312") &&
//                !editText.text.toString().equals("321")){
//                view.findViewById<TextView>(R.id.warnmsg).text = "Invalid input"
//            }else{
//                view.findViewById<TextView>(R.id.warnmsg).text = "Thanks for your input"
//                File(downloadFolder?.path + File.separator + "test10.txt").appendText(
//                    editText.text.toString() + "\n"
//                )
//            }
        }

        view.findViewById<View>(R.id.estimation1_next_button).setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.estimation2_dest, null)
        )
    }
}