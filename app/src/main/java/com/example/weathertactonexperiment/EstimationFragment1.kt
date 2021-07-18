package com.example.weathertactonexperiment

import android.content.Context
import android.media.MediaPlayer
import android.media.audiofx.HapticGenerator
import android.os.Bundle
import android.os.Environment
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import org.w3c.dom.Text
import java.io.File

class EstimationFragment1 : Fragment() {

    var v1: Int = 0
    var v2: Int = 0
    var v3: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.estimation_fragment1, container, false)
//        val downloadFolder = requireContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
//        if(!File(downloadFolder?.path + File.separator + "random.txt").exists()){
//            return inflater.inflate(R.layout.end_fragment, container, false)
//        }else{
//            return inflater.inflate(R.layout.estimation_fragment1, container, false)
//        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        view.findViewById<TextView>(R.id.e1_warnmsg).text = v1.toString()

        val vibrator = activity?.getSystemService(Vibrator::class.java)
        val WAVEFORM_DURATION_1 = longArrayOf(100)
        val WAVEFORM_DURATION_2 = longArrayOf(500)
        val WAVEFORM_DURATION_3 = longArrayOf(1000)
        val WAVEFORM_AMPLITUDE_1 = intArrayOf(64)
        val WAVEFORM_AMPLITUDE_2 = intArrayOf(128)
        val WAVEFORM_AMPLITUDE_3 = intArrayOf(255)
        val WAVEFORM_TIMINGS_1 = longArrayOf(50, 15, 50, 15, 50, 15, 50, 15, 50, 15)
        val WAVEFORM_TIMINGS_2 = longArrayOf(50, 50, 50, 50, 50, 50, 50, 50, 50, 50)
        val WAVEFORM_TIMINGS_3 = longArrayOf(50, 800, 50, 800, 50, 800, 50, 800, 50, 800)
        val WAVEFORM_TIMINGS_4 = longArrayOf(50, 100, 50, 100, 50, 100, 50, 100, 50, 100)
        val WAVEFORM_TIMINGS_5 = longArrayOf(50, 200, 50, 200, 50, 200, 50, 200, 50, 200)
        val WAVEFORM_AMPLITUDES_1 = intArrayOf(128, 0, 128, 0, 128, 0, 128, 0, 128, 0)
        val WAVEFORM_AMPLITUDES_2 = intArrayOf(255, 0, 255, 0, 255, 0, 255, 0, 255, 0)

        val downloadFolder = requireContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
//        if(!File(downloadFolder?.path + File.separator + "random.txt").exists()){
//            findNavController().navigate(R.id.end_dest)
//            Navigation.createNavigateOnClickListener(R.id.end_dest, null)
//        }
        var lines = File(downloadFolder?.path + File.separator + "random.txt").readLines()
        var num = lines.get(0).toInt()
        File(downloadFolder?.path + File.separator + "random.txt").delete()
        for(i in 2..lines.size){
            File(downloadFolder?.path + File.separator + "random.txt").appendText(lines.get(i-1) + "\n")
        }

        if(num == 1){
            view.findViewById<TextView>(R.id.e1_title).text = "Temperature"
        }
        if(num == 2){
            view.findViewById<TextView>(R.id.e1_title).text = "Wind"
        }
        if(num == 3){
            view.findViewById<TextView>(R.id.e1_title).text = "Rain"
        }

        view.findViewById<View>(R.id.e1b1).setOnClickListener {
//            var mediaPlayer = MediaPlayer.create(requireContext(), R.raw.audacity_200hz_amp0_5_1000ms)
//            var hapticGenerator = HapticGenerator.create(mediaPlayer.audioSessionId)
//            hapticGenerator.enabled = true
//            mediaPlayer.start()
//            mediaPlayer.setOnCompletionListener {
//                hapticGenerator.release()
//                hapticGenerator.close()
//                mediaPlayer?.release()
//                mediaPlayer = null
//            }

            vibrator?.vibrate(
                VibrationEffect.createWaveform(WAVEFORM_DURATION_1, WAVEFORM_AMPLITUDE_2, -1))
        }

        view.findViewById<View>(R.id.e1b2).setOnClickListener {
//            var mediaPlayer = MediaPlayer.create(requireContext(), R.raw.audacity_300hz_amp0_5_1000ms)
//            var hapticGenerator = HapticGenerator.create(mediaPlayer.audioSessionId)
//            hapticGenerator.enabled = true
//            mediaPlayer.start()
//            mediaPlayer.setOnCompletionListener {
//                hapticGenerator.release()
//                hapticGenerator.close()
//                mediaPlayer?.release()
//                mediaPlayer = null
//            }
            vibrator?.vibrate(
                VibrationEffect.createWaveform(WAVEFORM_DURATION_2, WAVEFORM_AMPLITUDE_2, -1))
        }

        view.findViewById<View>(R.id.e1b3).setOnClickListener {
//            var mediaPlayer = MediaPlayer.create(requireContext(), R.raw.audacity_300hz_amp1_1000ms)
//            var hapticGenerator = HapticGenerator.create(mediaPlayer.audioSessionId)
//            hapticGenerator.enabled = true
//            mediaPlayer.start()
//            mediaPlayer.setOnCompletionListener {
//                hapticGenerator.release()
//                hapticGenerator.close()
//                mediaPlayer?.release()
//                mediaPlayer = null
//            }
            vibrator?.vibrate(
                VibrationEffect.createWaveform(WAVEFORM_DURATION_3, WAVEFORM_AMPLITUDE_2, -1))
        }

        view.findViewById<RadioButton>(R.id.radio_button_high_1).setOnClickListener(View.OnClickListener {
            v1 = 1
        })

        view.findViewById<RadioButton>(R.id.radio_button_high_2).setOnClickListener(View.OnClickListener {
            v1 = 2
        })

        view.findViewById<RadioButton>(R.id.radio_button_high_3).setOnClickListener(View.OnClickListener {
            v1 = 3
        })

        view.findViewById<RadioButton>(R.id.radio_button_medium_1).setOnClickListener(View.OnClickListener {
            v2 = 1
        })

        view.findViewById<RadioButton>(R.id.radio_button_medium_2).setOnClickListener(View.OnClickListener {
            v2 = 2
        })

        view.findViewById<RadioButton>(R.id.radio_button_medium_3).setOnClickListener(View.OnClickListener {
            v2 = 3
        })

        view.findViewById<RadioButton>(R.id.radio_button_low_1).setOnClickListener(View.OnClickListener {
            v3 = 1
        })

        view.findViewById<RadioButton>(R.id.radio_button_low_2).setOnClickListener(View.OnClickListener {
            v3 = 2
        })

        view.findViewById<RadioButton>(R.id.radio_button_low_3).setOnClickListener(View.OnClickListener {
            v3 = 3
        })

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

        view.findViewById<View>(R.id.e1_submit_button).setOnClickListener {
//            val inputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

            val downloadFolder = requireContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)

//            val editText1 = view.findViewById<EditText>(R.id.e1_editTextNumber1)
//            val editText2 = view.findViewById<EditText>(R.id.e1_editTextNumber2)
//            val editText3 = view.findViewById<EditText>(R.id.e1_editTextNumber3)

//            if(!(editText1.text.toString().equals("1") || editText1.text.toString().equals("2") || editText1.text.toString().equals("3"))
//                || !(editText2.text.toString().equals("1") || editText2.text.toString().equals("2") || editText2.text.toString().equals("3"))
//                || !(editText3.text.toString().equals("1") || editText3.text.toString().equals("2") || editText3.text.toString().equals("3"))
//                || editText1.text.toString().equals(editText2.text.toString())
//                || editText1.text.toString().equals(editText3.text.toString())
//                || editText2.text.toString().equals(editText3.text.toString())){
            if(!(v1==1 || v1==2 || v1==3)
                || !(v2==1 || v2==2 || v2==3)
                || !(v3==1 || v3==2 || v3==3)
                || v1 == v2 || v1 == v3 || v2 == v3){
                view.findViewById<TextView>(R.id.e1_warnmsg).text = "Invalid input"
            }else{
                File(downloadFolder?.path + File.separator + "data.txt").appendText(
                    v1.toString() + "-" + v2.toString() + "-" + v3.toString() + "\n"
                )
                if(lines.size == 1){
                    findNavController().navigate(R.id.end_dest)
                }else{
                    findNavController().navigate(R.id.estimation1_dest)
                }
            }
        }



//        view.findViewById<View>(R.id.estimation1_next_button).setOnClickListener (
//            Navigation.createNavigateOnClickListener(R.id.estimation2_dest, null)
//        )
//        view.findViewById<View>(R.id.estimation1_next_button).setOnClickListener {
//            findNavController().navigate(R.id.estimation2_dest)
//        }
    }
}