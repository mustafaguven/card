package com.example.mguven.reminderpoc

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mguven.service.BackgroundService

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val backgroundService = BackgroundService()
    val intent = Intent(this, backgroundService::class.java)
    startService(intent)
    
  }
}
