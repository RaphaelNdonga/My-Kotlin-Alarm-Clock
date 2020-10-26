package com.example.android.mykotlinalarmclock.utils

import android.widget.TimePicker
import android.os.Build

class TimePickerUtil {
    fun getTimePickerHour(timePicker:TimePicker):Int{
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            timePicker.hour
        } else {
            timePicker.currentHour
        }
    }
    fun getTimePickerMinutes(timePicker: TimePicker):Int{
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            timePicker.minute
        } else {
            timePicker.currentMinute
        }
    }
}