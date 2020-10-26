package com.example.android.mykotlinalarmclock.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.mykotlinalarmclock.data.Alarm
import com.example.android.mykotlinalarmclock.screens.alarmdisplay.AlarmAdapter

@BindingAdapter("alarmListData")
fun bindAlarmRecyclerView(recyclerView: RecyclerView,data:List<Alarm>?){
    val adapter = recyclerView.adapter as AlarmAdapter
    adapter.submitList(data)
}

@BindingAdapter("alarmTime")
fun TextView.bindAlarmTime(alarm:Alarm?){
    val timeText = "${alarm?.hour} : ${alarm?.minute}"
    text = timeText
}

@BindingAdapter("alarmRecurringDays")
fun TextView.bindAlarmRecurringDays(alarm:Alarm?){
    alarm?.let {
        val recurringDaysText = getRecurringDaysText(alarm)
        text = recurringDaysText
    }
}