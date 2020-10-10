package com.example.android.mykotlinalarmclock.utils

import android.widget.TimePicker

class TimePickerUtil {
    fun getTimePickerHour(timePicker:TimePicker):Int{
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            timePicker.hour
        } else {
            timePicker.currentHour
        }
    }
    fun getTimePickerMinutes(timePicker: TimePicker):Int{
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            timePicker.hour
        } else {
            timePicker.currentHour
        }
    }
}