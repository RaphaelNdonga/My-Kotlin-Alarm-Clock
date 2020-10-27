package com.example.android.mykotlinalarmclock.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.mykotlinalarmclock.data.Alarm
import com.example.android.mykotlinalarmclock.screens.alarmdisplay.AlarmAdapter

@BindingAdapter("alarmListData")
fun bindAlarmRecyclerView(recyclerView: RecyclerView,data:List<Alarm>?){
    val adapter = recyclerView.adapter as AlarmAdapter
    adapter.submitList(data)
}