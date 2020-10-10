package com.example.android.mykotlinalarmclock.data

data class Alarm(
    val alarmId: Int,
    val hour: Int,
    val minute: Int,
    var started: Boolean,
    val recurring: Boolean,
    val monday: Boolean,
    val tuesday: Boolean,
    val wednesday: Boolean,
    val thursday: Boolean,
    val friday: Boolean,
    val saturday: Boolean,
    val sunday: Boolean,
    val title: String
)
