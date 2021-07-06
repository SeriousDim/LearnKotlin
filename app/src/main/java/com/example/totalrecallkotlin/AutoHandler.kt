package com.example.totalrecallkotlin

import android.os.Handler
import android.os.Looper
import android.os.Message

typealias HandlerAction = (String) -> Unit

class AutoHandler(loop: Looper, var action : HandlerAction) : Handler(loop){

    override fun handleMessage(msg: Message){
        when (msg.what){
            0 -> action("Integer:" + msg.obj)
            1 -> action("String: " + msg.obj)
        }
    }

}