package com.example.android.mykotlinalarmclock.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import com.example.android.mykotlinalarmclock.service.AlarmService
import com.example.android.mykotlinalarmclock.service.RescheduleAlarmService
import com.example.android.mykotlinalarmclock.utils.*
import timber.log.Timber
import java.util.*

class AlarmBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let {
            if (Intent.ACTION_BOOT_COMPLETED == intent.action) {
                Timber.i("Alarm Rebooted")
                startRescheduleAlarmService(context)
                return
            }
            if (intent.getBooleanExtra(RECURRING,false)){
                Timber.i("Alarm Received")
                startAlarmService(context,intent)
                return
            }
            if (alarmIsToday(intent)){
                startAlarmService(context,intent)
                return
            }
        }

    }

    private fun startRescheduleAlarmService(context: Context?) {
        val intentService = Intent(context, RescheduleAlarmService::class.java)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            context?.startForegroundService(intentService)
            return
        }
        context?.startService(intentService)

    }

    private fun startAlarmService(context: Context?, intent: Intent) {
        val intentService = Intent(context, AlarmService::class.java)
        intentService.putExtra(TITLE,intent.getStringExtra(TITLE))
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            context?.startForegroundService(intent)
            return
        }
        context?.startService(intent)
    }

    private fun alarmIsToday(intent: Intent): Boolean {
        val calendar = Calendar.getInstance()

        return when(calendar.get(Calendar.DAY_OF_WEEK)){
            Calendar.MONDAY -> intent.getBooleanExtra(MONDAY,false)
            Calendar.TUESDAY -> intent.getBooleanExtra(TUESDAY,false)
            Calendar.WEDNESDAY -> intent.getBooleanExtra(WEDNESDAY,false)
            Calendar.THURSDAY -> intent.getBooleanExtra(THURSDAY,false)
            Calendar.FRIDAY -> intent.getBooleanExtra(FRIDAY,false)
            Calendar.SATURDAY -> intent.getBooleanExtra(SATURDAY,false)
            Calendar.SUNDAY -> intent.getBooleanExtra(SUNDAY,false)
            else -> false
        }
    }
}