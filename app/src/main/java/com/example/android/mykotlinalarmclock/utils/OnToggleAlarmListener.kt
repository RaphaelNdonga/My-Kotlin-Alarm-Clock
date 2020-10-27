package com.example.android.mykotlinalarmclock.utils

import com.example.android.mykotlinalarmclock.data.Alarm

interface OnToggleAlarmListener {
    fun onToggle(alarm:Alarm)
}