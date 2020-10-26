package com.example.android.mykotlinalarmclock.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.mykotlinalarmclock.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ring)
    }
}