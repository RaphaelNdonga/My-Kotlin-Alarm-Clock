package com.example.android.mykotlinalarmclock.screens.alarmdisplay

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.android.mykotlinalarmclock.data.Alarm
import com.example.android.mykotlinalarmclock.data.AlarmDao
import kotlinx.coroutines.*

class AlarmListViewModel(private val dao: AlarmDao) : ViewModel() {
    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    val alarmList:LiveData<List<Alarm>> = dao.observeAllAlarms()

    fun update(alarm: Alarm){
        uiScope.launch {
            daoUpdate(alarm)
        }
    }

    private suspend fun daoUpdate(alarm:Alarm){
        withContext(Dispatchers.IO){
            dao.update(alarm)
        }
    }


}