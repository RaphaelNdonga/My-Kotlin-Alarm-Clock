package com.example.android.mykotlinalarmclock.screens.createalarm

import android.app.AlarmManager
import android.app.Application
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.getSystemService
import androidx.lifecycle.AndroidViewModel
import com.example.android.mykotlinalarmclock.data.Alarm
import com.example.android.mykotlinalarmclock.data.AlarmDao
import com.example.android.mykotlinalarmclock.receiver.AlarmBroadcastReceiver
import com.example.android.mykotlinalarmclock.service.AlarmService
import com.example.android.mykotlinalarmclock.utils.*
import kotlinx.coroutines.*
import timber.log.Timber
import java.util.*

class SetAlarmViewModel(private val app: Application,private val dao: AlarmDao) : AndroidViewModel(app) {

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)


    fun saveAlarm(alarm: Alarm) {
        uiScope.launch {
            insertAlarm(alarm)
        }
        scheduleAlarm(alarm,app)
    }
    private suspend fun insertAlarm(alarm:Alarm){
        withContext(Dispatchers.IO){
            dao.insert(alarm)
        }
    }
}