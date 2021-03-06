package com.example.mguven.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.support.annotation.Nullable
import com.example.mguven.broadcast.ScreenActionReceiver

class BackgroundService : Service() {

  private val receiver = ScreenActionReceiver()

  override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    super.onStartCommand(intent, flags, startId)

    registerReceiver(receiver, receiver.filter)
    return START_STICKY
  }

  override fun onDestroy() {
    super.onDestroy()
    unregisterReceiver(receiver)
  }

  @Nullable
  override fun onBind(intent: Intent?): IBinder? {
    return null
  }
}