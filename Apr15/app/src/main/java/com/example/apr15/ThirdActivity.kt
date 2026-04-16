package com.example.apr15

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity: AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(LOGTAB, "ThirdActivity")

        setContentView(R.layout.third)

        var str = StringBuffer()
        intent.extras?.keySet()?.forEach {
            str.append(it)
            str.append(": ")
            str.append(intent.getStringExtra(it))
            str.append("\n ")
        }
        if (intent.hasExtra(Intent.EXTRA_TEXT))
            intent.getStringExtra(Intent.EXTRA_TEXT)

        val tv = findViewById<TextView>(R.id.textview)
        tv.text = str

    }
}