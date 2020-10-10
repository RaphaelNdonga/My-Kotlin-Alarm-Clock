package com.example.android.mykotlinalarmclock.screens.createalarm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.mykotlinalarmclock.R
import com.example.android.mykotlinalarmclock.databinding.FragmentSetAlarmBinding
import kotlinx.android.synthetic.main.fragment_set_alarm.*
import kotlin.random.Random

class SetAlarmFragment : Fragment() {

    private lateinit var viewModel: SetAlarmViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSetAlarmBinding>(
            inflater,
            R.layout.fragment_set_alarm,
            container,
            false
        )
        val app = requireActivity().application
        viewModel = ViewModelProvider(this,SetAlarmViewModelFactory(app)).get(SetAlarmViewModel::class.java)
        binding.scheduleAlarmBtn.setOnClickListener {
            findNavController().navigate(R.id.action_setAlarmFragment_to_alarmListFragment)
        }
        binding.recurringCheckBox.setOnCheckedChangeListener { _, isChecked: Boolean ->
            if (isChecked) {
                daysCheckBoxes.visibility = View.VISIBLE
                return@setOnCheckedChangeListener
            }
            daysCheckBoxes.visibility = View.GONE
        }

        return binding.root
    }
}