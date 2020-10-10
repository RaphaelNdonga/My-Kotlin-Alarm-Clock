package com.example.android.mykotlinalarmclock.utils

import java.util.*

object DayUtil {
    fun toDay(day: Int): String {
        return when(day){
            Calendar.MONDAY-> "MONDAY"
            Calendar.TUESDAY-> "TUESDAY"
            Calendar.WEDNESDAY-> "WEDNESDAY"
            Calendar.THURSDAY-> "THURSDAY"
            Calendar.FRIDAY-> "FRIDAY"
            Calendar.SATURDAY-> "SATURDAY"
            Calendar.SUNDAY-> "SUNDAY"
            else -> throw Exception("Could not locate day")
        }
    }

}