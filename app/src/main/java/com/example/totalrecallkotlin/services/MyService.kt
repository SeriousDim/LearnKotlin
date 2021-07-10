package com.example.totalrecallkotlin.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.util.concurrent.TimeUnit

class MyService: Service(){

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        doMyAction()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.d("LOG_TAG", "MyService was destroyed")
        super.onDestroy()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    fun doMyAction(){
        Thread(Runnable {
            for (i in 1..10) {
                Log.d("LOG_TAG", "i = $i")
                try {
                    TimeUnit.SECONDS.sleep(2)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                stopSelf()
            }
        }).start()
    }

}