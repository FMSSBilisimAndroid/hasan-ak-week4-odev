package com.hasan.retrofitapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hasan.retrofitapp.R
import com.hasan.retrofitapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}