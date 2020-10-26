package com.example.android.mykotlinalarmclock.screens.ring

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class RingViewModelFactory(private val app:Application) :ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RingViewModel(app) as T
    }
}