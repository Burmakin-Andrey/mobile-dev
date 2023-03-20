package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_guess.*
import kotlinx.coroutines.delay

class GuessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)
        var left = intent.getIntExtra("left", 0)
        var right = intent.getIntExtra("right", 0)

        textViewNumber.text = ((left+right) /2).toString()

        buttonLess.setOnClickListener{
            right = ((left+right) /2)
            textViewNumber.text = ((left+right) /2).toString()
        }

        buttonMore.setOnClickListener{
            left = ((left+right) /2)
            textViewNumber.text = ((left+right) /2).toString()
        }

        buttonEquals.setOnClickListener{
            textViewNumber.text = "Good"
            finish()
        }
    }
}