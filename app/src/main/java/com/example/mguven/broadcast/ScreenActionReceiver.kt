package com.example.mguven.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import com.example.mguven.reminderpoc.CardActivity

class ScreenActionReceiver : BroadcastReceiver() {

  private val TAG = "ScreenActionReceiver"

  val filter: IntentFilter
    get() {
      val filter = IntentFilter()
      filter.addAction(Intent.ACTION_SCREEN_OFF)
      filter.addAction(Intent.ACTION_SCREEN_ON)
      return filter
    }

  override fun onReceive(
    context: Context,
    intent: Intent
  ) {

    val action = intent.action

    when (action) {
      Intent.ACTION_SCREEN_ON -> Log.d(TAG, "screen is on...")
      Intent.ACTION_SCREEN_OFF -> Log.d(TAG, "screen is off...")
      Intent.ACTION_USER_PRESENT -> {
        Log.d(TAG, "screen is unlock...")

        val intent =
            Intent(context.applicationContext, CardActivity::class.java)
        intent.addFlags(
            Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)

      }
    }

  }

}