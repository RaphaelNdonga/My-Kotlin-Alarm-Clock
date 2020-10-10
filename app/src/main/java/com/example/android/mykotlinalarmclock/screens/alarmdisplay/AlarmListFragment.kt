package com.example.android.mykotlinalarmclock.screens.alarmdisplay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.mykotlinalarmclock.R
import com.example.android.mykotlinalarmclock.databinding.AlarmListFragmentBinding

class AlarmListFragment : Fragment() {

    companion object {
        fun newInstance() = AlarmListFragment()
    }

    private lateinit var viewModel: AlarmListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<AlarmListFragmentBinding>(
            inflater,
            R.layout.alarm_list_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(AlarmListViewModel::class.java)
        binding.addAlarmBtn.setOnClickListener {
            findNavController().navigate(R.id.action_alarmListFragment_to_setAlarmFragment)
        }
        return binding.root
    }

}