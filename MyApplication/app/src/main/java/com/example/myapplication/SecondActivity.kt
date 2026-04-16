package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.myapplication.R


class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(LOGTAB, "Second Activity created")
        setContentView(R.layout.second)

        val backButton = findViewById<Button>(R.id.backButton)

        backButton.setOnClickListener {
            finish()
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(LOGTAB, "SecondActivity onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.v(LOGTAB, "SecondActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v(LOGTAB, "SecondActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v(LOGTAB, "SecondActivity onStop")
    }
}