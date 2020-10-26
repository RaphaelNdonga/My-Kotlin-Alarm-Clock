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
import com.example.android.mykotlinalarmclock.data.AlarmDao
import com.example.android.mykotlinalarmclock.databinding.AlarmListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AlarmListFragment : Fragment() {

    private lateinit var viewModel: AlarmListViewModel

    @Inject
    lateinit var dao:AlarmDao

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
        val adapter = AlarmAdapter()
        binding.alarmRecyclerView.adapter = adapter
        viewModel = ViewModelProvider(this,AlarmListViewModelFactory(dao)).get(AlarmListViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.addAlarmBtn.setOnClickListener {
            findNavController().navigate(R.id.action_alarmListFragment_to_setAlarmFragment)
        }
        return binding.root
    }

}