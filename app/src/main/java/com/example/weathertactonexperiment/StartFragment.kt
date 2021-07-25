package com.example.weathertactonexperiment

import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import java.io.File

class StartFragment : Fragment() {

    var v_gender: Int = 0
    var v_age: Int = 0
    var v_usage: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.start_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RadioButton>(R.id.radio_button_gender_female).setOnClickListener(View.OnClickListener {
            v_gender = 1
        })

        view.findViewById<RadioButton>(R.id.radio_button_gender_male).setOnClickListener(View.OnClickListener {
            v_gender = 2
        })

        view.findViewById<RadioButton>(R.id.radio_button_gender_others).setOnClickListener(View.OnClickListener {
            v_gender = 3
        })

        view.findViewById<RadioButton>(R.id.radio_button_gender_nottosay).setOnClickListener(View.OnClickListener {
            v_gender = 4
        })

        view.findViewById<RadioButton>(R.id.radio_button_weatherappusage_level1).setOnClickListener(View.OnClickListener {
            v_usage = 1
        })

        view.findViewById<RadioButton>(R.id.radio_button_weatherappusage_level2).setOnClickListener(View.OnClickListener {
            v_usage = 2
        })

        view.findViewById<RadioButton>(R.id.radio_button_weatherappusage_level3).setOnClickListener(View.OnClickListener {
            v_usage = 3
        })

//        val button = view.findViewById<Button>(R.id.start_training_button)
//        button?.setOnClickListener(
//            Navigation.createNavigateOnClickListener(R.id.training_dest, null)
//        )
        view.findViewById<Button>(R.id.start_training_button).setOnClickListener {
            if(v_gender == 0 || v_usage == 0){
                view.findViewById<TextView>(R.id.start_warnmsg).text = getString(R.string.start_warnmsg)
            }else{
                val downloadFolder = requireContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
                File(downloadFolder?.path + File.separator + "data.txt").appendText(
                    "----------" + "\n" +
                    v_gender.toString() + view.findViewById<EditText>(R.id.editText_age).text.toString() + v_usage.toString() + "\n"
                )
                findNavController().navigate(R.id.training_dest)
            }
        }
    }
}