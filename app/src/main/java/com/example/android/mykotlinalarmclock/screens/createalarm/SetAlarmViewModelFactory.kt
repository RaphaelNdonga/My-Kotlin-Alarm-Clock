package com.example.android.mykotlinalarmclock.screens.createalarm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class SetAlarmViewModelFactory(private val app:Application):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SetAlarmViewModel(app) as T
    }
}