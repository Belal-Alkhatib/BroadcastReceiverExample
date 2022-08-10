package com.example.self_dev_test_broadecast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.wifi.WifiManager.ACTION_PICK_WIFI_NETWORK
import android.util.Log
import android.widget.Toast

class MyReciver:BroadcastReceiver() {

     lateinit var  mp : MediaPlayer


    override fun onReceive(context: Context?, intent: Intent?) {

        
        mp = MediaPlayer.create(context,R.raw.pawerdisconnected)
        when(intent!!.action){
            Intent.ACTION_POWER_CONNECTED ->{
                Thread.sleep(2000)
                mp = MediaPlayer.create(context,R.raw.connectvois)
                mp.start()
                mp.isLooping = false
            }
            Intent.ACTION_POWER_DISCONNECTED ->{
                Thread.sleep(2000)
                mp = MediaPlayer.create(context,R.raw.pawerdisconnected)
                mp.start()
                mp.isLooping = false
            }
            Intent.ACTION_AIRPLANE_MODE_CHANGED ->{
                Thread.sleep(2000)
                mp = MediaPlayer.create(context,R.raw.airplanemode)
                mp.start()
                mp.isLooping = false
            }
            "android.net.wifi.WIFI_STATE_CHANGED" ->{
                Thread.sleep(2000)
                mp = MediaPlayer.create(context,R.raw.internetchanged)
                mp.start()
                mp.isLooping = false
            }

        }
    }


}