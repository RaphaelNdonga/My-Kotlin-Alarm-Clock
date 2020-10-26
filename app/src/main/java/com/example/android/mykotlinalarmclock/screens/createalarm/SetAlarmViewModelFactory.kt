package com.example.android.mykotlinalarmclock.screens.createalarm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.mykotlinalarmclock.data.AlarmDao

@Suppress("UNCHECKED_CAST")
class SetAlarmViewModelFactory(private val app:Application,private val dao:AlarmDao):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SetAlarmViewModel(app,dao) as T
    }
}