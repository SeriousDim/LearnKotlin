package com.example.totalrecallkotlin

import android.os.Handler
import android.os.Message
import java.util.concurrent.TimeUnit

class MyThread(var handler: Handler) : Thread(){

    override fun run() {
        for (i in 1..1000){
            TimeUnit.SECONDS.sleep(1)
            var msg = handler.obtainMessage(0, 254)
            handler.sendMessage(msg)
            TimeUnit.SECONDS.sleep(1)
            msg = handler.obtainMessage(1, "You are fuckin slave of system")
            handler.sendMessage(msg)
        }
    }

}