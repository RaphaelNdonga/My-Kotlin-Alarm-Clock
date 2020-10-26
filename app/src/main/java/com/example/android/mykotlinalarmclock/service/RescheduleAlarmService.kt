package com.example.android.mykotlinalarmclock.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.Observer
import com.example.android.mykotlinalarmclock.data.Alarm
import com.example.android.mykotlinalarmclock.data.AlarmDao
import com.example.android.mykotlinalarmclock.utils.scheduleAlarm
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RescheduleAlarmService:LifecycleService(){

    @Inject
    lateinit var dao:AlarmDao

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        dao.observeAllAlarms().observe(this, {
            it?.forEach { alarm->
                if(alarm.started){
                    scheduleAlarm(alarm,this.application)
                }
            }
        })
        return START_STICKY
    }

}
