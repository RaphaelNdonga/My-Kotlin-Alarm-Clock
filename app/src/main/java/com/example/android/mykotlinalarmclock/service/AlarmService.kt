package com.example.android.mykotlinalarmclock.service

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.os.Vibrator
import androidx.core.app.NotificationCompat
import com.example.android.mykotlinalarmclock.R
import com.example.android.mykotlinalarmclock.activities.RingActivity
import com.example.android.mykotlinalarmclock.utils.CHANNEL_ID
import com.example.android.mykotlinalarmclock.utils.TITLE
import timber.log.Timber

class AlarmService : Service() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var vibrator: Vibrator

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.alarm)
        mediaPlayer.isLooping = true
        vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Timber.i("Service is running...")
        val notificationIntent = Intent(this, RingActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)

        val alarmTitle = "${intent?.getStringExtra(TITLE)}"

        val notificationBuilder =
            NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle(alarmTitle)
                .setContentText("Ring... Ring").setSmallIcon(R.drawable.ic_alarm_black)
                .setContentIntent(pendingIntent)

        mediaPlayer.start()
        val pattern: LongArray = longArrayOf(0, 100, 1000)
        vibrator.vibrate(pattern, 0)

        startForeground(1,notificationBuilder.build())

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        vibrator.cancel()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

}
