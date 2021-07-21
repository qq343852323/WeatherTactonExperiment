package com.example.weathertactonexperiment

import android.media.MediaPlayer
import android.media.audiofx.HapticGenerator
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.io.File

class TrainingFragment : Fragment() {

    var v1: Int = 0
    var v2: Int = 0
    var v3: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.training_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val list: MutableList<Int?> = (0..10).toMutableList()
//        list.shuffle()
//        view.findViewById<TextView>(R.id.training_warnmsg).text = list.size.toString()
        val arr = Array(3) { it }
        arr.shuffle()
        if(arr.get(0) == 0){
            view.findViewById<TextView>(R.id.training_title).text = "Temperature"
            view.findViewById<TextView>(R.id.training_question_level1).text = "Which vibration represents high temperature?"
            view.findViewById<TextView>(R.id.training_question_level2).text = "Which vibration represents medium temperature?"
            view.findViewById<TextView>(R.id.training_question_level3).text = "Which vibration represents low temperature?"
        }
        if(arr.get(0) == 1){
            view.findViewById<TextView>(R.id.training_title).text = "Wind"
            view.findViewById<TextView>(R.id.training_question_level1).text = "Which vibration represents strong wind?"
            view.findViewById<TextView>(R.id.training_question_level2).text = "Which vibration represents medium wind?"
            view.findViewById<TextView>(R.id.training_question_level3).text = "Which vibration represents light wind?"
        }
        if(arr.get(0) == 2){
            view.findViewById<TextView>(R.id.training_title).text = "Rain"
            view.findViewById<TextView>(R.id.training_question_level1).text = "Which vibration represents heavy rain?"
            view.findViewById<TextView>(R.id.training_question_level2).text = "Which vibration represents medium rain?"
            view.findViewById<TextView>(R.id.training_question_level3).text = "Which vibration represents light rain?"
        }


        view.findViewById<View>(R.id.training_vibration_button1).setOnClickListener {
            var mediaPlayer = MediaPlayer.create(requireContext(), R.raw.silence200msamp0_5on50off50dur2s)
            var hapticGenerator = HapticGenerator.create(mediaPlayer.audioSessionId)
            hapticGenerator.enabled = true
            mediaPlayer.start()
            mediaPlayer.setOnCompletionListener {
                hapticGenerator.release()
                hapticGenerator.close()
                mediaPlayer?.release()
                mediaPlayer = null
            }
        }

        view.findViewById<View>(R.id.training_vibration_button2).setOnClickListener {
            var mediaPlayer = MediaPlayer.create(requireContext(), R.raw.silence200msamp0_5on50off800dur2s)
            var hapticGenerator = HapticGenerator.create(mediaPlayer.audioSessionId)
            hapticGenerator.enabled = true
            mediaPlayer.start()
            mediaPlayer.setOnCompletionListener {
                hapticGenerator.release()
                hapticGenerator.close()
                mediaPlayer?.release()
                mediaPlayer = null
            }
        }

        view.findViewById<View>(R.id.training_vibration_button3).setOnClickListener {
            var mediaPlayer = MediaPlayer.create(requireContext(), R.raw.silence200msamp0_5on50off15dur2s)
            var hapticGenerator = HapticGenerator.create(mediaPlayer.audioSessionId)
            hapticGenerator.enabled = true
            mediaPlayer.start()
            mediaPlayer.setOnCompletionListener {
                hapticGenerator.release()
                hapticGenerator.close()
                mediaPlayer?.release()
                mediaPlayer = null
            }
        }

        view.findViewById<RadioButton>(R.id.training_radio_group_level1_button1).setOnClickListener(View.OnClickListener {
            v1 = 1
        })

        view.findViewById<RadioButton>(R.id.training_radio_group_level1_button2).setOnClickListener(View.OnClickListener {
            v1 = 2
        })

        view.findViewById<RadioButton>(R.id.training_radio_group_level1_button3).setOnClickListener(View.OnClickListener {
            v1 = 3
        })

        view.findViewById<RadioButton>(R.id.training_radio_group_level2_button1).setOnClickListener(View.OnClickListener {
            v2 = 1
        })

        view.findViewById<RadioButton>(R.id.training_radio_group_level2_button2).setOnClickListener(View.OnClickListener {
            v2 = 2
        })

        view.findViewById<RadioButton>(R.id.training_radio_group_level2_button3).setOnClickListener(View.OnClickListener {
            v2 = 3
        })

        view.findViewById<RadioButton>(R.id.training_radio_group_level3_button1).setOnClickListener(View.OnClickListener {
            v3 = 1
        })

        view.findViewById<RadioButton>(R.id.training_radio_group_level3_button2).setOnClickListener(View.OnClickListener {
            v3 = 2
        })

        view.findViewById<RadioButton>(R.id.training_radio_group_level3_button3).setOnClickListener(View.OnClickListener {
            v3 = 3
        })

        view.findViewById<View>(R.id.training_submit_button).setOnClickListener {
            if(!(v1==1 || v1==2 || v1==3)
                || !(v2==1 || v2==2 || v2==3)
                || !(v3==1 || v3==2 || v3==3)
                || v1 == v2 || v1 == v3 || v2 == v3){
                view.findViewById<TextView>(R.id.training_warnmsg).text = "Invalid input"
            }else{
                findNavController().navigate(R.id.betweenTrainingEstimation_dest)
            }
        }
    }
}