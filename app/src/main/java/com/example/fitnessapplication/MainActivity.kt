package com.example.fitnessapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitnessapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}