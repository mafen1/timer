package com.example.servise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.servise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                binding.textView.text = "Service work"
            }
        }

        binding.btnStop.setOnClickListener {
            Intent(this, MyService::class.java).also {
                val dataString = binding.seend.text.toString()
                it.putExtra("Extra", dataString)
                stopService(it)

            }
        }
    }
}