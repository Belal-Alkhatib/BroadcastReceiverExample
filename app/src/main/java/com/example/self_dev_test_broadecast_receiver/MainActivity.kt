package com.example.self_dev_test_broadecast_receiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat.getAction
import androidx.core.view.accessibility.AccessibilityEventCompat.getAction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var myReceiver = MyReciver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val intentFilter = IntentFilter()

            intentFilter.addAction(Intent.ACTION_POWER_CONNECTED)
            intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
            intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED")

            registerReceiver(myReceiver,intentFilter)
        }

        btnSend.setOnClickListener {
            val i = Intent("com.b.alkhatib")
            i.putExtra("com.b.alkhatib.msg","Hello From Send Broadcast")
            sendBroadcast(i)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myReceiver)

    }
}