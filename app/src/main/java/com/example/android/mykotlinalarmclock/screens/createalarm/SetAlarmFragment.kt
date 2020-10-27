package com.example.android.mykotlinalarmclock.screens.createalarm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.mykotlinalarmclock.R
import com.example.android.mykotlinalarmclock.data.Alarm
import com.example.android.mykotlinalarmclock.data.AlarmDao
import com.example.android.mykotlinalarmclock.databinding.FragmentSetAlarmBinding
import com.example.android.mykotlinalarmclock.utils.EventObserver
import com.example.android.mykotlinalarmclock.utils.TimePickerUtil
import com.example.android.mykotlinalarmclock.utils.scheduleAlarm
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_set_alarm.*
import javax.inject.Inject

@AndroidEntryPoint
class SetAlarmFragment : Fragment() {

    private lateinit var viewModel: SetAlarmViewModel
    private lateinit var binding: FragmentSetAlarmBinding

    @Inject
    lateinit var dao:AlarmDao

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_set_alarm,
            container,
            false
        )
        val app = requireActivity().application

        viewModel = ViewModelProvider(
            this,
            SetAlarmViewModelFactory(app,dao)
        ).get(SetAlarmViewModel::class.java)

        binding.lifecycleOwner = this

        binding.scheduleAlarmBtn.setOnClickListener {
            viewModel.saveAlarm(setAlarm())
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

    private fun setAlarm(): Alarm {
        return Alarm(
            hour = TimePickerUtil().getTimePickerHour(binding.setAlarmTimePicker),
            minute = TimePickerUtil().getTimePickerMinutes(binding.setAlarmTimePicker),
            recurring = binding.recurringCheckBox.isChecked,
            monday = binding.monCheckBox.isChecked,
            tuesday = binding.tueCheckBox.isChecked,
            wednesday = binding.wedCheckBox.isChecked,
            thursday = binding.thurCheckBox.isChecked,
            friday = binding.friCheckBox.isChecked,
            saturday = binding.satCheckBox.isChecked,
            sunday = binding.sunCheckBox.isChecked,
            title = binding.editTextAlarmTitle.text.toString()
        )
    }
}