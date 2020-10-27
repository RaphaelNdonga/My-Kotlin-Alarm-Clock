package com.example.android.mykotlinalarmclock.screens.createalarm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.android.mykotlinalarmclock.data.Alarm
import com.example.android.mykotlinalarmclock.data.AlarmDao
import com.example.android.mykotlinalarmclock.utils.scheduleAlarm
import kotlinx.coroutines.*

class SetAlarmViewModel(private val app: Application,private val dao: AlarmDao) : AndroidViewModel(app) {

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)


    fun saveAlarm(alarm: Alarm) {
        scheduleAlarm(alarm,app)
        uiScope.launch {
            insertAlarm(alarm)
        }
    }
    private suspend fun insertAlarm(alarm:Alarm){
        withContext(Dispatchers.IO){
            dao.insert(alarm)
        }
    }

}