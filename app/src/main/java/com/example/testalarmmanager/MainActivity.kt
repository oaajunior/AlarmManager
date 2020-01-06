package com.example.testalarmmanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnComecarAlarm = findViewById<Button>(R.id.buttonStartAlarm)

        btnComecarAlarm.setOnClickListener{
            setAlarm()
        }
    }

    fun setAlarm(){

        val alarm = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
        alarm.setRepeating(AlarmManager.ELAPSED_REALTIME, 5000, 5000, pendingIntent)
    }

}
