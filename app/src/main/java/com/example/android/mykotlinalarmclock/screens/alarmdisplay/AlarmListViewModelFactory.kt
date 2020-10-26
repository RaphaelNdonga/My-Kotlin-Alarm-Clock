package com.example.android.mykotlinalarmclock.screens.alarmdisplay

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.mykotlinalarmclock.data.AlarmDao

@Suppress("UNCHECKED_CAST")
class AlarmListViewModelFactory(private val dao:AlarmDao):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AlarmListViewModel(dao) as T
    }
}