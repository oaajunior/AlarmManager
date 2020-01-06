package com.example.testalarmmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationCompat

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
      setNotification(context)
    }

    private fun setNotification(context: Context?){
        createChannel(context)
        val notification = NotificationCompat.Builder(context!!.applicationContext, "test alarm")
            .setContentTitle("Alarm Manager")
            .setContentText("O tempo acabou")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setAutoCancel(true)
            .build()
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(12, notification)

    }


    private fun createChannel(context: Context?){

        val channel = NotificationChannel("test alarm","nome qualquer", NotificationManager.IMPORTANCE_HIGH)
        val manager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)
    }
}