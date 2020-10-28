package com.example.android.mykotlinalarmclock.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
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
            Toast.makeText(context, "Alarm Received", Toast.LENGTH_SHORT).show()
            if (!intent.getBooleanExtra(RECURRING, false)) {
                Timber.i("Non recurring alarm should start")
                startAlarmService(context, intent)
                return
            }
            if (alarmIsToday(intent)) {
                Timber.i("Recurring alarm should start")
                startAlarmService(context, intent)
            }

        }
    }

    private fun startRescheduleAlarmService(context: Context?) {
        val serviceIntent = Intent(context, RescheduleAlarmService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context?.startForegroundService(serviceIntent)
            return
        }
        context?.startService(serviceIntent)

    }

    private fun startAlarmService(context: Context?, intent: Intent) {
        val serviceIntent = Intent(context, AlarmService::class.java)
        serviceIntent.putExtra(TITLE, intent.getStringExtra(TITLE))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Timber.i("start Alarm service has been called")
            context?.startForegroundService(serviceIntent)
            return
        }
        context?.startService(serviceIntent)
    }

    private fun alarmIsToday(intent: Intent): Boolean {
        val calendar = Calendar.getInstance()

        return when (calendar.get(Calendar.DAY_OF_WEEK)) {
            Calendar.MONDAY -> intent.getBooleanExtra(MONDAY, false)
            Calendar.TUESDAY -> intent.getBooleanExtra(TUESDAY, false)
            Calendar.WEDNESDAY -> intent.getBooleanExtra(WEDNESDAY, false)
            Calendar.THURSDAY -> intent.getBooleanExtra(THURSDAY, false)
            Calendar.FRIDAY -> intent.getBooleanExtra(FRIDAY, false)
            Calendar.SATURDAY -> intent.getBooleanExtra(SATURDAY, false)
            Calendar.SUNDAY -> intent.getBooleanExtra(SUNDAY, false)
            else -> false
        }
    }
}

